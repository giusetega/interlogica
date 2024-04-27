FROM openjdk:17-jdk

WORKDIR /opt/app

COPY /src/main/resources/static/images /opt/app/static/images
COPY target/pasticceria-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]

# COMANDI DA ESEGUIRE
# VOLUME
# docker volume create interlogica_volume

# BACKEND
# git checkout sul BE
# docker buildx build . -t interlogica:v1.0.0
# docker tag adabae0c08c7 giusetega/interlogica:v1.1.0
# docker push giusetega/interlogica:v1.1.0
# docker run -d -p 8080:8080 -h localhost -v interlogica_volume:/opt/app/static/tmp --name dockerized-backend interlogica:v1.0.0

# FRONTEND
# git checkout sul FE
# docker buildx build . -t interlogica-fe:v1.0.0
# docker tag adabae0c08c7 giusetega/interlogica_fe:v1.1.0
# docker push giusetega/interlogica_fe:v1.1.0
# docker run -d -p 3000:3000 -h localhost -v /app/node_modules -v interlogica_volume:/react-docker-interlogica/public/img --name dockerized-react-app interlogica-fe:v1.0.0

#AWS
# sudo docker run -d -p 8080:8080 -h localhost -v interlogica_volume:/opt/app/static/tmp giusetega/interlogica:v1.0.0
# sudo docker run -d -p 3000:3000 -h localhost -v /app/node_modules -v interlogica_volume:/react-docker-interlogica/public/img giusetega/interlogica_fe:v1.0.0

# COMMAND FOR LINUX EC2 INSTANCE
#sudo yum update
#sudo yum install -y docker
#sudo systemctl start docker
#sudo service docker start
#Add security group -> all traffic
