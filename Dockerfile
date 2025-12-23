FROM eclipse-temurin:17-jdk

#ARG JAR_FILE=target/spring-boot-web.jar
ARG JAR_FILE=target/*.jar

# cd /opt/app
WORKDIR /app

VOLUME ["/app/static/tmp"]

COPY /src/main/resources/static/images /app/static/images

# cp target/spring-boot-web.jar /app/app.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

# java -jar /app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]


#Commands:
#  bake        Build from a file
#  build       Start a build
#  create      Create a new builder instance
#  inspect     Inspect current builder instance
#  ls          List builder instances
#  rm          Remove a builder instance
#  stop        Stop builder instance
#  use         Set the current builder instance
#  version     Show buildx version information
#docker buildx build .

#docker buildx build . -t interlogica:v1.0.1
#docker run -p 8080:8080 interlogica:v1.0.1
#docker run -p 8080:8080 -h localhost interlogica:v1.0.1
#docker run -d -p 8080:8080 -h localhost -v prova_volume:/tmp interlogica:v1.1.4

# COMMANDI DA ESEGUIRE
# VOLUME
# docker volume create interlogica_volume

# BACKEND
# git checkout sul BE
# docker buildx build . -t interlogica:v1.0.0
# docker run -d -p 8080:8080 -h localhost -v interlogica_volume:/opt/app/static/tmp --name dockerized-backend interlogica:v1.0.0

# FRONTEND
# git checkout sul FE
# docker buildx build . -t interlogica-fe:v1.0.0
# docker run -d -p 3000:3000 -h localhost -v /app/node_modules -v interlogica_volume:/react-docker-interlogica/public/img --name dockerized-react-app interlogica-fe:v1.0.0
