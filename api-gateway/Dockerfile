
FROM eclipse-temurin:17-jre-jammy
ARG JAR_FILE=target/api-gateway.jar
ADD ${JAR_FILE} api-gateway.jar
ENTRYPOINT ["java", "-jar", "/api-gateway.jar"]
