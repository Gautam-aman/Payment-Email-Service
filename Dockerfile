

FROM eclipse-temurin:21-jdk


WORKDIR /app

COPY target/Demo-Docker-image-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java" , "-jar" , "app.jar"]

#instruction to create docker image