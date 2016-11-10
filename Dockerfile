FROM java:8

MAINTAINER Nicolas Byl <nicolas.byl@codecentric.de>

# build application
ADD . /app
WORKDIR /app
RUN ./mvnw package

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/target/demo.jar"]