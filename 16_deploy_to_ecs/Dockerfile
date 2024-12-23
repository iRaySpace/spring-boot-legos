FROM amazoncorretto:21-alpine3.18
WORKDIR /app
COPY build/libs/ecs-0.1.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
