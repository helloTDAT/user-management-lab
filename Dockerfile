FROM maven:3.8-openjdk-17 AS build
WORKDIR /app
COPY springboot-app/pom.xml .
COPY springboot-app/src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-focal
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
