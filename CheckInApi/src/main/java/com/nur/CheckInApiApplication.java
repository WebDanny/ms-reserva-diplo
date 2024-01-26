package com.nur;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import com.nur.annotations.Generated;
import com.nur.command.OrderManageService;
import com.nur.model.Reserve;
import com.nur.repositories.ICommendRepository;
import com.nur.repositories.IPersonRepository;
import com.nur.repositories.IReserveRepository;
import com.nur.repositories.IUserRepository;
import com.nur.repositories.commend.CommendCrudRepositoryImpl;
import com.nur.repositories.persons.PersonsCrudRepositoryImpl;
import com.nur.repositories.reserve.ReserveCrudRepositoryImpl;
import com.nur.repositories.users.UserCrudRepositoryImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.Executor;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueBytesStoreSupplier;
import org.apache.kafka.streams.state.Stores;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication()
@ComponentScan(
    basePackages = {
      "controllers",
      "com.nur.repositories",
      "com.nur",
      "event",
      "core",
    })
@EntityScan("com.nur.model")
@EnableJpaRepositories(basePackages = {"com.nur.repositories"})
@EnableTransactionManagement
@OpenAPIDefinition(info = @Info(title = "NurBnB microservices", version = "1.0.0"))
@Generated
@EnableKafkaStreams
@EnableAsync
public class CheckInApiApplication {

  private static final Logger LOG = LoggerFactory.getLogger(CheckInApiApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(CheckInApiApplication.class, args);
  }

  @Bean(name = "personsRepository")
  public IPersonRepository personsRepository() {
    return new PersonsCrudRepositoryImpl();
  }

  @Bean(name = "usersRepository")
  public IUserRepository usersRepository() {
    return new UserCrudRepositoryImpl();
  }

  @Bean(name = "commendRepository")
  public ICommendRepository commendRepository() {
    return new CommendCrudRepositoryImpl();
  }

  @Bean(name = "reserveRepository")
  public IReserveRepository reserveRepository() {
    return new ReserveCrudRepositoryImpl();
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      System.out.println("Let's inspect the beans provided by Spring Boot:");

      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName);
      }
    };
  }

  @Bean
  Pipeline pipeline(
      ObjectProvider<Command.Handler> commandHandlers,
      ObjectProvider<Notification.Handler> notificationHandlers,
      ObjectProvider<Command.Middleware> middlewares) {
    return new Pipelinr()
        .with(commandHandlers::stream)
        .with(notificationHandlers::stream)
        .with(middlewares::orderedStream);
  }

  @Bean
  public NewTopic orders() {
    return TopicBuilder.name("reserve").partitions(1).replicas(1).compact().build();
  }

  @Bean
  public NewTopic propiedadesTopic() { // stock-reserve
    return TopicBuilder.name("propiedades-reserve").partitions(1).replicas(1).compact().build();
  }

  @Bean
  public NewTopic paymentTopic() {
    return TopicBuilder.name("payment-reserve").partitions(1).replicas(1).compact().build();
  }

  @Autowired OrderManageService orderManageService;

  @Bean
  public KStream<Long, Reserve> stream(StreamsBuilder builder) {
    System.out.println("STREAM ANTES ENVIAR A PAYMENT");
    JsonSerde<Reserve> orderSerde = new JsonSerde<>(Reserve.class);
    KStream<Long, Reserve> stream =
        builder.stream("propiedades-reserve", Consumed.with(Serdes.Long(), orderSerde));

    stream
        .join(
            builder.stream("payment-reserve"),
            orderManageService::confirm,
            JoinWindows.of(Duration.ofSeconds(10)),
            StreamJoined.with(Serdes.Long(), orderSerde, orderSerde))
        .peek((k, o) -> LOG.info("PAYMENT: {}", o))
        .to("reserve");

    return stream;
  }

  @Bean
  public KTable<Long, Reserve> table(StreamsBuilder builder) {
    KeyValueBytesStoreSupplier store = Stores.persistentKeyValueStore("reserve");
    JsonSerde<Reserve> orderSerde = new JsonSerde<>(Reserve.class);
    KStream<Long, Reserve> stream =
        builder.stream("reserve", Consumed.with(Serdes.Long(), orderSerde));
    return stream.toTable(
        Materialized.<Long, Reserve>as(store)
            .withKeySerde(Serdes.Long())
            .withValueSerde(orderSerde));
  }

  @Bean
  public Executor taskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(5);
    executor.setMaxPoolSize(5);
    executor.setThreadNamePrefix("kafkaSender-");
    executor.initialize();
    return executor;
  }
}
