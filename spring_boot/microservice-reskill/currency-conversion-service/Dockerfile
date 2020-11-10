FROM openjdk:11

ADD ./target/currency-conversion-service-0.0.1-SNAPSHOT.jar /usr/src/currency-conversion-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "currency-conversion-service-0.0.1-SNAPSHOT.jar"]
