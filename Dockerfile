FROM maven:3.8.5-openjdk-17
COPY /target/architecture-0.0.1-SNAPSHOT.jar architecture.jar
EXPOSE 8080
CMD ["java", "-jar", "architecture.jar"]