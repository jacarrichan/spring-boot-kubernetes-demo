FROM openjdk:8-jdk-oracle

ADD spring-boot-demo-0.0.1-SNAPSHOT.jar /app.jar

ENV TZ=Asia/Shanghai

ENTRYPOINT [ "java", "-jar", "/app.jar" ]
