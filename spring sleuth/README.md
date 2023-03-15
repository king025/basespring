# Spring Sleuth - Zipkin server

## Configuring Zipkin server

We will be running our Zipkin server inside our Docker container. Hence, docker will be a pre-requisite for the below instructions.

Once we have Docker available in our local system. We can now open our CLI and run the command below:
```sh
docker run -d -p 9411:9411 openzipkin/zipkin
```
Now we have a running instance of Zipkin locally. We can verify if the server is really running in our Docker window.

## Running the code

Run the code to access our test endpoint to generate the application logs with Sleuth integrated.

```sh
mvn spring-boot:run
```

## Endpoint for testing

Access the url [/inquiry](http://localhost:8080/inquiry) and [/inquiry/1](http://localhost:8080/inquiry/1)

This will generate some logs in the system and will be viewable in our Zipkin server.