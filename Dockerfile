# Usa la imagen oficial de Maven para compilar la aplicación
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app

# Copia el archivo POM y descarga las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia el resto de los archivos y compila la aplicación
COPY src ./src
RUN mvn clean package -DskipTests

# Imagen final basada en Eclipse Temurin JDK para ejecutar la aplicación
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia el archivo JAR de la fase de construcción
COPY --from=build /app/target/geoipservice-1.0.0.jar /app/geoipservice.jar

# Puerto expuesto por la aplicación
EXPOSE 8081

# Define la red como parte de geoip_network
# Esta línea se agrega en el archivo Docker Compose, no en el Dockerfile

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "/app/geoipservice.jar"]