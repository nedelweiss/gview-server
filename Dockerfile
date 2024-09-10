FROM openjdk:17-jdk

RUN mkdir /app
COPY build/libs/gview-server-0.0.1-SNAPSHOT.jar /app

ENTRYPOINT ["java", "-jar", "/app/gview-server-0.0.1-SNAPSHOT.jar"]