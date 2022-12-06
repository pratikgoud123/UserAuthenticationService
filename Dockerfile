FROM openjdk:11-jre-slim
WORKDIR usr/lib
ADD ./target/UserAuthenticationService-0.0.1-SNAPSHOT.jar /usr/lib/UserAuthenticationService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","UserAuthenticationService-0.0.1-SNAPSHOT.jar"]