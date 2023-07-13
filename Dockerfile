FROM alpine:3.17.0
RUN apk update & apk add openjdk17.jre
COPY target/chat-app-0.0.1-SNAPSHOT.jar chatapp.jar
EXPOSE 8080
CMD ["java", "-jar", "chatapp.jar"]