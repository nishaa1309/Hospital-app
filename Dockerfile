FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=build hospital-0.0.1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]