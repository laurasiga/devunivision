FROM eclipse-temurin:17-jre-alpine
COPY target/devunivision-0-0-1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]