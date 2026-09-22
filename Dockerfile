# Stage 1: Build the application using Gradle
FROM gradle:8-jdk25 AS build
WORKDIR /app
COPY --chown=gradle:gradle . .
RUN gradle bootJar --no-daemon -x test

# Stage 2: Minimal runtime environment
FROM eclipse-temurin:25-jre-jammy
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 26867
ENTRYPOINT ["java", "-jar", "app.jar"]
