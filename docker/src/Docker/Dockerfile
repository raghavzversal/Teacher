FROM openjdk:12-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/docker.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]