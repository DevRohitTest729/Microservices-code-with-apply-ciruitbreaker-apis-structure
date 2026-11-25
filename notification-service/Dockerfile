
FROM eclipse-temurin:17-jre-jammy
ARG JAR_FILE=target/notification-service.jar
ADD ${JAR_FILE} notification-service.jar
ENTRYPOINT ["java", "-jar", "/notification-service.jar"]
