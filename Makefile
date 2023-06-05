MVN_REPO=${HOME}/.m2
CODE_BASE=${PWD}
IMAGE_TAG=usho:1.0

clean:
	mvn clean

pack:
	mvn package

dpack: clean
	docker run --rm \
 		--volume ${MVN_REPO}:/root/.m2 \
 		--volume ${CODE_BASE}:/app \
 		--workdir /app s3vt/maven:latest mvn install

image: pack
	docker build -t ${IMAGE_TAG} -f docker/usho/Dockerfile .

up: pack
	docker compose --project-directory . -f docker/docker-compose.yaml up -d --build

down:
	docker compose -f docker/docker-compose.yaml down

stop:
	docker compose -f docker/docker-compose.yaml stop

logs:
	docker compose -f docker/docker-compose.yaml logs --follow

usho:
	curl  -d '{longUrl: "google.com"}' \
	-X POST \
	-H 'Content-Type: application/json' \
	http://localhost:4000/usho

getall:
	curl http://localhost:4000/usho