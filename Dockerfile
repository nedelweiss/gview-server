FROM openjdk:17-jdk-alpine

WORKDIR /tmp
COPY . /tmp
RUN chmod +x gradlew
RUN ./gradlew clean build

ENTRYPOINT ["java", "-jar", "/tmp/build/libs/gview-server-0.0.1-SNAPSHOT.jar"]