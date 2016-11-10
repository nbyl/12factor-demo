FROM java:8

MAINTAINER Nicolas Byl <nicolas.byl@codecentric.de>

# build application
RUN mkdir /tmp/build
ADD . /tmp/build
WORKDIR /tmp/build
RUN ./mvnw package

# install application
RUN cp target/demo.jar /app.jar
RUN chmod u+x /app.jar

# cleanup image
WORKDIR /
RUN rm -rf /tmp/build

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]