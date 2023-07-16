#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
COPY java-api /home/app/java-api
COPY react-app /home/app/react-app
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /home/app/java-api/target/java-api-0.0.1-SNAPSHOT.jar /usr/local/lib/WebApp.jar
EXPOSE 8080 
ENTRYPOINT ["java", "-jar", "/usr/local/lib/WebApp.jar"]
