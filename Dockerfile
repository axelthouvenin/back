FROM maven:3.8-openjdk-18-slim as builder

WORKDIR /usr/src/app

COPY . .

RUN mvn clean package -DskipTests=true

FROM openjdk:18-jdk

EXPOSE 8080

WORKDIR /usr/src/app

ENV SPRING_DATASOURCE_URL="jdbc:postgresql://localhost:5432/base"
ENV SPRING_DATASOURCE_USERNAME=user
ENV SPRING_DATASOURCE_PASSWORD=password

COPY --from=builder /usr/src/app/target/fs-back-*.jar fs-back.jar

CMD ["java", "-jar", "fs-back.jar"]
