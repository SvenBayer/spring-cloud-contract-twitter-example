FROM frolvlad/alpine-oraclejdk8:slim
LABEL maintainer="sven.bayer.mail@gmail.com"
VOLUME ["/var/log/tweetexample"]
ADD maven/@JAR@ app.jar

RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "java", "$JAVA_OPTS","-Djava.security.egd=file:/dev/./urandom", "-jar", "--logging.path=/var/log/tweetexample", "/app.jar" ]
