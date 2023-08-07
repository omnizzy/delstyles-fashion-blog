FROM openjdk:17-oracle
LABEL authors="decagon"
COPY target/delStyles-0.0.1-SNAPSHOT.jar delStyles-image.jar
EXPOSE 9090
EXPOSE 5432
ENTRYPOINT ["java", "-jar", "delStyles-image.jar"]