# Build stage
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn -DskipTests package

# Running stage
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /build/target/*.jar app.jar
COPY src/main/resources/static/images/ /app/static/tmp/
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]


# docker volume create interlogica_volume
# docker buildx build . -t interlogica:v1.0.0
# docker run -d -p 8080:8080 -h localhost -v interlogica_volume:/app/static/tmp --name dockerized-backend interlogica:v1.0.0
