FROM amazoncorretto:17

MAINTAINER SebastianContreras

COPY target/Curriculum-backend-0.0.1-SNAPSHOT.jar Curriculum-backend-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/Curriculum-backend-0.0.1-SNAPSHOT.jar"]