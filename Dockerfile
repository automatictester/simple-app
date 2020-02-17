FROM openjdk:8-jre-alpine
ADD build/libs/simple-app-*.jar simple-app.jar
CMD java -jar simple-app.jar
EXPOSE 8080
