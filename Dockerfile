FROM openjdk:11-jre-bullseye
WORKDIR application
ARG JAR_FILE=customer-service/build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]