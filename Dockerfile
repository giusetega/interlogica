FROM openjdk:17-jdk

# Refer to Maven build -> finalName
#ARG JAR_FILE=target/spring-boot-web.jar
ARG JAR_FILE=target/pasticceria-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

VOLUME /tmp

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]



#FROM openjdk:17-jdk-alpine
#VOLUME /tmp
#EXPOSE 8080
##ARG JAR_FILE=target/spring-boot-docker.jar
##ARG JAR_FILE=target/pasticceria-0.0.1-SNAPSHOT.jar
##ADD ${JAR_FILE} app.jar
#COPY target/pasticceria-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

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