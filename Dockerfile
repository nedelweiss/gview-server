FROM ubuntu:latest as builder
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .
RUN chmod +x gradlew
RUN ./gradlew bootJar --no-daemon --info

FROM openjdk:17-jdk-slim
EXPOSE 8080
COPY --from=builder /build/libs/gview-server-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]