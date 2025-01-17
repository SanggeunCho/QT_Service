# Use Maven to build the project
FROM maven:3.8.4-openjdk-11 AS build

# Set working directory
WORKDIR /app

# Copy project files to the container
COPY pom.xml .
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# Use Tomcat to run the application
FROM tomcat:9.0

# Copy the built WAR file to the Tomcat webapps directory
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]

# docker build -t coupang-spring .
# docker run -d -p 8080:8080 --name spring-container coupang-spring

# docker rm -f spring-container