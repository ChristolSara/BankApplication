FROM openjdk:17-slim as build

MAINTAINER SaraaMiss

COPY target/gatewayserver-0.0.1-SNAPSHOT.jar gatewayserver-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/gatewayserver-0.0.1-SNAPSHOT.jar"]