FROM amazoncorretto:11.0.15-alpine3.15
ARG JAR_FILE=build/libs/poc-spring-microservice-swagger-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]