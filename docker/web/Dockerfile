FROM openjdk:11-jre

ADD assembly/ks-task-hash.jar app/ks-task-hash.jar
ADD assembly/config/hash.properties app/config/hash.properties

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "ks-task-hash.jar"]
