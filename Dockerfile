FROM openjdk:11-jre
ADD assembly/ks-task-hash.jar ks-task-hash.jar
ADD assembly/config/application.properties config/application.properties
ADD assembly/config/application-docker.properties config/application-docker.properties
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "ks-task-hash.jar"]
