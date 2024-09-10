FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/calculator-app-1.0-SNAPSHOT.jar /app/calculator-app-1.0-SNAPSHOT.jar

CMD ["java", "-jar", "/app/calculator-app-1.0-SNAPSHOT.jar"]