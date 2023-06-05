FROM vsaps/java:17

RUN mkdir /app
WORKDIR /app

ENV MYSQL_HOST=galera \
    MYSQL_PORT=3306 \
    MYSQL_USER=ushouser \
    MYSQL_DB=usho \
    MYSQL_PASSWORD=password \
    REDIS_HOST=redis \
    REDIS_PORT=6379

COPY  target/usho-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "usho-0.0.1-SNAPSHOT.jar" ]
