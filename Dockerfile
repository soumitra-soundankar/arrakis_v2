#
# Build stage
#
FROM maven:3.6.0-jdk-17-slim AS build
COPY java-api /home/app/java-api
COPY react-app /home/app/react-app
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:17-jre-slim
COPY --from=build /home/app/java-api/target/java-api-1.0-SNAPSHOT.jar /usr/local/lib/WebApp.jar
EXPOSE 8080 
ENTRYPOINT ["java", "-jar", "/usr/local/lib/WebApp.jar"]
