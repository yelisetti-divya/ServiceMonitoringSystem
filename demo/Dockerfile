FROM maven:3.9.6-eclipse-temurin-17

WORKDIR /app

# Copy pom.xml first (for dependency caching)
COPY pom.xml .

RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# Render requires port 8080
EXPOSE 8080

# Run Spring Boot jar
CMD ["java","-jar","target/*.jar"]