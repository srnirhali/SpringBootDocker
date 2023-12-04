# Use a base image with JDK 17 and Gradle installed
FROM gradle:jdk17-jammy AS builder

# Set the working directory in the container
WORKDIR /app

# Copy only the Gradle-related files to optimize caching
COPY build.gradle .
COPY settings.gradle .
COPY gradlew .
COPY gradle ./gradle

# Download and cache the Gradle dependencies
RUN ./gradlew --no-daemon --console=plain dependencies

# Copy the application source code
COPY . .

# Build the application
RUN gradle clean bootJar

# Use AdoptOpenJDK's JRE 17 slim image for the final runtime
FROM gradle:jdk17-jammy AS runtime

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR from the builder stage to the final image
COPY --from=builder /app/build/libs/demo-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the port that the Spring Boot app runs on
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
