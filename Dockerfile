FROM openjdk:17 as builder

WORKDIR /tmp
COPY . /tmp

RUN chmod +x gradlew
RUN ./gradlew clean build

FROM openjdk:17-jdk-slim

RUN mkdir /app
COPY --from=builder /tmp/build/libs/gview-server-0.0.1-SNAPSHOT.jar /app

CMD java -jar /app/gview-server-0.0.1-SNAPSHOT.jar