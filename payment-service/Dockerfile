
FROM eclipse-temurin:17-jre-jammy
ARG JAR_FILE=target/payment-service.jar
ADD ${JAR_FILE} paymentservice.jar
ENTRYPOINT ["java", "-jar", "/paymentservice.jar"]
