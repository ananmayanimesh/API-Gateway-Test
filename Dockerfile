FROM openjdk:8
EXPOSE 8080
ADD target/docker_restapi_test.jar docker_restapi_test.jar
ENTRYPOINT ["java","-jar","docker_restapi_test.jar"]