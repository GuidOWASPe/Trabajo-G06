# Usar la imagen de Maven para construir el proyecto
FROM eclipse-temurin:21 as build

# Instalar Maven
RUN apt-get update && \
    apt-get install -y maven

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias
COPY pom.xml /app/
RUN mvn dependency:go-offline

# Copiar el código fuente y compilar la aplicación
COPY src /app/src
RUN mvn clean package -DskipTests

# Usar una imagen más ligera de JDK para ejecutar la aplicación
FROM eclipse-temurin:21-jdk-alpine

# Establecer el directorio de trabajo para la aplicación
WORKDIR /app

# Copiar el archivo JAR generado en la fase de construcción
COPY --from=target /target/demo-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto 8080
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]