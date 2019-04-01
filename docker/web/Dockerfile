FROM openjdk:11-jre

ADD assembly/ks-task-hash.jar app/ks-task-hash.jar
ADD assembly/config/application.properties app/config/application.properties
ADD assembly/config/application-docker.properties app/config/application-docker.properties

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "ks-task-hash.jar"]
