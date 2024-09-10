FROM openjdk:17-jdk-alpine

WORKDIR /tmp
COPY . /tmp
RUN chmod +x gradlew
RUN ./gradlew clean build

COPY build/libs/gview-server-0.0.1-SNAPSHOT.jar /app

ENTRYPOINT ["java", "-jar", "/app/gview-server-0.0.1-SNAPSHOT.jar"]