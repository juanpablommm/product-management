FROM openjdk:17-jdk-slim

ARG VERSION="latest"

LABEL authors="juanpablo montoya opsinal" version=${VERSION} description="Microservice in charge of managing products in e-commerce"

ENV APP_ENV=DEV

EXPOSE 8081

WORKDIR /app

COPY build/libs/product-management-1.1.0.jar .

ENTRYPOINT ["java", "-jar", "/app/product-management-1.1.0.jar", "--spring.profiles.active=local"]
