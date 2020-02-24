FROM openjdk:8-jdk-alpine

COPY ./target/sccapi-0.0.1-SNAPSHOT.jar  /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch sccapi-docker-0.0.1-SNAPSHOT.jar '

ENTRYPOINT ["java","-jar","sccapi-docker-0.0.1-SNAPSHOT.jar "]