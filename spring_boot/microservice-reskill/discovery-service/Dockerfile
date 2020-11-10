FROM openjdk:11

ADD ./target/discovery-service-0.0.1-SNAPSHOT.jar /usr/src/discovery-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "discovery-service-0.0.1-SNAPSHOT.jar"]