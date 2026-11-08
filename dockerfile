# Etapa 1: Build con Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Runtime ligero
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiar el ejecutable generado en el módulo presentacion
COPY --from=build /app/presentacion/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]