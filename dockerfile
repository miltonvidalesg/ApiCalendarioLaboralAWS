# Etapa 1: Compilación del proyecto con Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copiar archivos de configuración de dependencias primero para optimizar la caché de Docker
COPY pom.xml .
COPY presentacion/pom.xml presentacion/ 2>/dev/null || true

# Copiar el código fuente completo
COPY . .

# Compilar omitiendo ejecuciones de pruebas para acelerar la construcción
RUN mvn clean package -DskipTests

# Etapa 2: Imagen de ejecución (Runtime)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiar el JAR generado independientemente de la versión exacta
COPY --from=build /app/presentacion/target/*.jar app.jar 2>/dev/null || COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]