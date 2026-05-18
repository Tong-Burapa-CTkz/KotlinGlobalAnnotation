FROM eclipse-temurin:24-jre
LABEL authors="ctkzsama"

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]