FROM adoptopenjdk/openjdk11:ubi

ARG JAR_FILE=build/libs/rabbitmq-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]