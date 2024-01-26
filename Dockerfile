FROM alpine:3.18.4
RUN apk update
RUN echo "https://dl-cdn.alpinelinux.org/alpine/v3.18/community" >> /etc/apk/repositories
RUN apk update && apk --no-cache add openjdk17
ENV JAVA_HOME /usr/lib/jvm/default-jvm
RUN apk add --no-cache tzdata && \
    cp /usr/share/zoneinfo/America/La_Paz /etc/localtime && \
    echo "America/La_Paz" > /etc/timezone
RUN mkdir /logs

COPY CheckInApi/build/libs/*.jar /

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "check-in-api-1.0.jar", "--server.port=8080"]