FROM amazoncorretto:11-alpine-jdk
MAINTAINER luciafeliu
COPY target/ArgPro-0.0.1-SNAPSHOT.jar ArgPro-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ArgPro-0.0.1-SNAPSHOT.jar"]