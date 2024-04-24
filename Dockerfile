FROM openjdk:17-jdk

# Refer to Maven build -> finalName
#ARG JAR_FILE=target/spring-boot-web.jar
ARG JAR_FILE=target/pasticceria-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

#VOLUME /tmp

COPY /src/main/resources/static/images /opt/app/static/images

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

# java -jar /opt/app/app.jar
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

#docker buildx build . -t interlogica:v1.0.6
#docker run -d -p 8080:8080 -h localhost -v prova_volume:/opt/app/static/tmp interlogica:v1.0.6
