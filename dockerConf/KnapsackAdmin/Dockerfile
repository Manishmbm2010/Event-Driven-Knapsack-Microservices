FROM openjdk:8-jdk-alpine
COPY KnapSackAdmin/target/knapsack-version2-0.0.1.jar app.jar
ENTRYPOINT java -jar app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","app.jar","tar"]
#ENTRYPOINT bash
