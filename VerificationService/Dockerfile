#get the base image
FROM registry.access.redhat.com/ubi8/ubi:latest
LABEL authors="samson baraka"

#install java
RUN yum -y install java-21-openjdk-devel

#specify the volume
VOLUME /tmp

#expose the port
EXPOSE 9080

#add .jar file into the container
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]