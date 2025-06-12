# Usa la imagen base de Java (JDK 17 es común para Spring Boot 3)
FROM eclipse-temurin:17-jdk-alpine

# Crea el directorio para la app
WORKDIR /app

# Copia el JAR compilado (ajusta el nombre si es necesario)
COPY build/libs/ms-alumno-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto del contenedor (ajusta si usas otro)
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
