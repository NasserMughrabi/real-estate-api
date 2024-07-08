# Use an official OpenJDK runtime as a parent image
FROM openjdk:21
# FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application's jar file into the container
COPY target/real-estate-site-0.0.1-SNAPSHOT.jar /app/real-estate-site.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","real-estate-site.jar"]

# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]

# generate jar file 
# mvn clean package
# build container
# docker build -t real-estate-site .
# run container
# docker run -p 8080:8080 --name real-estate-site real-estate-site

# connect to ec2
# ssh -i /Users/nasser/Documents/ec2-keys/real-estate-ec2-key.pem ec2-user@ec2-54-87-234-87.compute-1.amazonaws.com

