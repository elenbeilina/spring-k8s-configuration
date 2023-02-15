FROM openjdk:17-jdk-alpine
COPY /target/*.jar spring-k8s-configuration-*.jar
ENTRYPOINT ["java","-jar","/spring-k8s-configuration-*.jar"]