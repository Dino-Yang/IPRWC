FROM openjdk:17
LABEL maintainer="DinoYang"
ADD target/IPRWC-1.jar springboot.jar
ENTRYPOINT ["java","-jar","springboot.jar"]