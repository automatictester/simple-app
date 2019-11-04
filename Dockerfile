FROM openjdk:8-jre-alpine
ADD simple-app-*.jar simple-app.jar
CMD java -jar simple-app.jar
EXPOSE 8080
