# Spring Boot 2 - Junit Mockito

Sample JUnit test classes with Mockito in Spring Boot application.

--------------------

PREREQUISITE


- IDE (Java 17, Spring Boot 2.7.x, Maven, SonarLint)
- Docker (MongoDb image)
- Postman

--------------------

MAVEN DEPENDENCIES

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<scope>test</scope>
		</dependency>

        <dependency>
            <groupId>de.flapdoodle.embed</groupId>
            <artifactId>de.flapdoodle.embed.mongo</artifactId>
            <scope>test</scope>
        </dependency>

--------------------

POSTMAN

Available in the postman collection folder. 
- SpringBoot2JunitMockito.postman_collection.json

--------------------

REFERENCES

- Spring Boot Tests with Mockito and JUnit 5 - https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockito-junit-example/
- Spring Boot 2 + JUnit 5 + Mockito - https://frontbackend.com/spring-boot/spring-boot-2-junit-5-mockito
- Spring Boot Testing | Writing JUnit Tests using JUnit and Mockito | Java Techie - https://www.youtube.com/watch?v=kXhYu939_5s
- How to use embedded MongoDB with SpringBoot v2.6.2? - https://stackoverflow.com/questions/70782360/how-to-use-embedded-mongodb-with-springboot-v2-6-2
- Deploying Spring Boot + MongoDB Application with Docker - https://www.appsdeveloperblog.com/deploying-spring-boot-mongodb-application-with-docker/

