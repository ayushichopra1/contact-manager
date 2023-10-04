FROM openjdk:11
COPY target/contact-manger-jpa-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9090
ENTRYPOINT ["sh", "-c", "sleep 15 && java -jar app.jar"]