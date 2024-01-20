package com.nur.command.reserve.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.ReserveDTO;
import com.nur.factories.reserve.IReserveFactory;
import com.nur.factories.reserve.ReserveFactory;
import com.nur.model.Reserve;
import com.nur.repositories.IReserveRepository;
import com.nur.util.ReserveMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateReserveHandler implements Command.Handler<CreateReserveCommand, ReserveDTO>{
    private final IReserveRepository reserveRepository;

    private final IReserveFactory reserveFactory;

    private KafkaTemplate<Long, Reserve> template;

    public CreateReserveHandler(IReserveRepository reserveRepository, KafkaTemplate<Long, Reserve> template) {
        this.reserveRepository = reserveRepository;
        this.template = template;
        this.reserveFactory = new ReserveFactory();
    }

    @Override
    public ReserveDTO handle(CreateReserveCommand request) {
        Reserve reserve = null;

        //agregar unit of work en los repositories
        try {
            reserve = reserveFactory.createReserve(request.reserveDTO.getDateIn(), request.reserveDTO.getDateOut(), request.reserveDTO.getDetails()
                    ,request.reserveDTO.getPropiedad());
            UUID id = reserveRepository.create(reserve);
            reserve.id = id;
            template.send("reserve", 1L, reserve);
            return ReserveMapper.from(reserve);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
