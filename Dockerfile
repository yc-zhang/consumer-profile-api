FROM openjdk:8-jre
MAINTAINER Yuchen <turalyon.zhangyc@gmail.com>

RUN mkdir /app
WORKDIR /app

ADD ./target/universal/stage /app/

CMD ["/app/bin/consumer-profile-api"]
