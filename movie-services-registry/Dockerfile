
FROM eclipse-temurin:17-jre-jammy
ARG JAR_FILE=target/movie-service-registry.jar
ADD ${JAR_FILE} movieregistry.jar
ENTRYPOINT ["java", "-jar", "/movieregistry.jar"]
