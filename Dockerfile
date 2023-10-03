FROM openjdk:11.0.11-jdk-slim
WORKDIR /app
COPY . /app
EXPOSE 8080
CMD ["./mvnw", "spring-boot:run"]
