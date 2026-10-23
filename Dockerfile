FROM maven:3.9-eclipse-temurin-25 AS build
WORKDIR /app
COPY Naruto/pom.xml .
COPY Naruto/src ./src
RUN mvn -q -DskipTests package
 
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75", "-jar", "app.jar"]