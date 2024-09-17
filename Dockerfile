# Usar la imagen de Maven para construir el proyecto
FROM maven:3.8.7-eclipse-temurin-17 as build

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias
COPY pom.xml /app/
RUN mvn dependency:go-offline

# Copiar el código fuente y compilar la aplicación
COPY src /app/src
RUN mvn clean package -DskipTests

# Usar una imagen más ligera de JDK para ejecutar la aplicación
FROM eclipse-temurin:17-jdk-alpine

# Establecer el directorio de trabajo para la aplicación
WORKDIR /app

# Copiar el archivo JAR generado en la fase de construcción
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto 8080
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]