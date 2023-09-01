#start with a base image containing java runtime
FROM  openjdk:17-slim as build


#information around who maintains the image (github tag)
MAINTAINER SaraaMiss

#add the application  jar to the container
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#excute the application
ENTRYPOINT ["java","-jar","/accounts-0.0.1-SNAPSHOT.jar"]