# 1 Use Java 17 as base image
#FROM bellsoft/liberica-openjdk-alpine:17
FROM eclipse-temurin:21-jdk-alpine

# 2 Copy the Spring Boot JAR file into the container
#COPY target/smart-wallet-application-2.0.0.jar app.jar
COPY target/smart-wallet-application-0.0.1-SNAPSHOT.jar app.jar

# 3 Define how to run the application
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]