FROM amazoncorretto:11-alpine-jdk

COPY target/crypto-market-server-0.0.1-SNAPSHOT.jar crypto-market-server-0.0.1.jar
ENTRYPOINT ["java","-jar","/crypto-market-server-0.0.1.jar"]