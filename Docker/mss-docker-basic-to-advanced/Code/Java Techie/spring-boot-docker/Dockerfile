# Use a base image with Java and Maven pre-installed
FROM maven:3.8.1

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file to the container
COPY pom.xml .

# Download the project dependencies
RUN mvn dependency:go-offline

# Copy the application source code to the container
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Create a new image with a smaller base image
FROM amazoncorretto:17-alpine3.16

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage to the current directory
COPY /target/spring-boot-docker.jar ./app.jar

# Expose the port that the Spring Boot application will listen on
EXPOSE 8080

# Set the command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]



#FROM openjdk:17
#EXPOSE 8080
#ADD target/spring-boot-docker.jar spring-boot-docker.jar
#ENTRYPOINT ["java", "-jar", "/spring-boot-docker.jar"]


# docker build -t app .
# docker run -p 9090:8080 spring-boot-docker.jar
# http://localhost:9090/welcome