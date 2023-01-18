FROM openjdk:17
MAINTAINER b2i-solutions.com
RUN mvn
COPY target/B2ITestProject.jar backend-test.jar
ENTRYPOINT ["java","-jar","/backend-test.jar"]