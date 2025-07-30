FROM openjdk:17-slim

# Set working directory
WORKDIR /app

# Copy the jar file
COPY target/lackey-number-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Use a minimal command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
