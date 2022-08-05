telegram-micro-boot.

Deploy in docker:

1.Create Dockerfile

******************************

FROM openjdk:11-jre-slim
ARG JAR_FILE=target/ ** [write here java.jar] **
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]rfile: 

*******************************

2. Install using Maven
mvn clean install

3. Create docker build: 

docker build -t [Docker container name] .

4. Run contianer (example)

docker run -p 8080:8085 [Docker container name]
