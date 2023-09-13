FROM openjdk:17-slim as build

MAINTAINER SaraaMiss

COPY target/eurekaServer-0.0.1-SNAPSHOT.jar eurekaServer-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/eurekaServer-0.0.1-SNAPSHOT.jar"]