FROM eclipse-temurin:17-jdk-alpine
COPY target/*.jar groomerMsg.jar
ENTRYPOINT ["java", "-jar", "groomerMsg.jar"]