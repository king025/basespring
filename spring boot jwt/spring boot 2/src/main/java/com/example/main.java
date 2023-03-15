package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class main {

	public static void main(String[] args) {
		SpringApplication.run(main.class, args);
		//ConfigurableApplicationContext context = new SpringApplicationBuilder(main.class).headless(false).run(args);
	}

}
