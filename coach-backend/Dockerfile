FROM maven:3.8.1-jdk-11-slim AS MAVEN_BUILD
COPY ./ ./
RUN mvn clean package -DskipTests
FROM openjdk:11
COPY --from=MAVEN_BUILD ./target/coach-backend-0.0.1-SNAPSHOT.jar coach-backend-0.0.1.jar
ENTRYPOINT ["java","-jar","/coach-backend-0.0.1.jar"]