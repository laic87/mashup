# Use an official lightweight OpenJDK image
FROM openjdk:17-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the Spring Boot fat JAR into the container
COPY target/*.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]