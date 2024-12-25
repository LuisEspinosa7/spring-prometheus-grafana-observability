FROM amazoncorretto:21.0.4-alpine
VOLUME /tmp 
COPY target/hotels-occupancy-1.0.0.0-SNAPSHOT.jar hotels-occupancy.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/hotels-occupancy.jar"]