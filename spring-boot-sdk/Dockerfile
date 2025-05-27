FROM maven:3.8-openjdk-8 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM maven:3.8-jdk-8-slim 
COPY --from=build /target/org.springframework.boot-0.0.1-SNAPSHOT.jar springboot.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","springboot.jar"]