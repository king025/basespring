# springboot3-springdoc2
Sample springboot 3 project to demonstrate Springboot 3 and Swagger 2

## Pre-requisites

The following should be setup before attempting to import and run this project

* IDE
* JDK 17
* Maven
* Postman
* Docker

#### MongoDB in Docker
Run a MongoDB docker image  before running the app in IDE. Run the following commands by order.

```bash
docker pull mongo
docker image ls
docker run -d --name mongo-on-docker -p 27017:27017 mongo
```

## About project

* SpringDoc Dependency

```bash
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.0.0</version>
		</dependency>
```


## Springdoc UI
Once app is running, you can access the Swagger UI in this link: http://localhost:8081/swagger-ui.html

## API Doc
This link will show you the API doc in JSON format: http://localhost:8081/api-docs

## References
For more info about Springdoc 2, you can check this link for their documentation: https://springdoc.org/v2/

