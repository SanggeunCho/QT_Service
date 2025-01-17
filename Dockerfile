# Use Tomcat to run the application
FROM tomcat:9.0

# Copy the built WAR file to the Tomcat webapps directory
COPY /target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]

# docker build -t coupang-spring .
# docker run -d -p 8080:8080 --name spring-container coupang-spring

# docker rm -f spring-container