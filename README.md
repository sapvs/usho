# usho
URL Shortner java spring application.
## Architecture
1. nginx frontend
1. Spring Boot Backend
    1. Spring Web
    1. Spring Redis
    1. Spring Data MySQL
1. Redis Cache
1. MySQL Galera Database


## Build
```mvn clean package```

## Run
### Makefile
```make up```

### Docker Compose
```
docker-compose up -f docker/docker-compose.yml
docker-compose -f docker/docker-compose.yml up --scale usho=2
```

### Stop
### Makefile
```make down```

### Docker Compose
```docker-compose down -f docker/docker-compose.yml```

### Using Makefile

#### Start
```make up```
#### Stop
```make down```
## Testing
Service runs behind nginx proxying to spring boot container usho
## Swagger Not Available
Access http://localhost:4000/swagger-ui.html
## Create short URL for long URL
### Make
```make usho```

### Curl
```
curl -X POST "http://localhost:4000/usho" \
-H  "accept: application/json" \
-H  "Content-Type: application/json" \
-d "http://www.google.com"
```

Response
```
{"id":"ailjoN","longURL":"http://www.google.com"}
```

#### Access short URL to confirm redirect in browser

```http://localhost:4000/usho/ailjoN```

### Delete mapping

```curl -X DELETE http://localhost:4000/usho/ailjoN```

Confirm again on the browser, accessing URL should return 404.
