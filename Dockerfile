# Use Amazon Corretto 17 to build the Spring Boot application
FROM amazoncorretto:17 as build
WORKDIR /workspace/app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw install -DskipTests

# Use Amazon Corretto 17 to run the Spring Boot application
FROM amazoncorretto:17
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target
COPY --from=build ${DEPENDENCY}/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]