FROM openjdk:17
LABEL maintainer="DinoYang"
ADD target/IPRWC-1.jar webapp.jar
ENTRYPOINT ["java","-jar","webapp.jar"]