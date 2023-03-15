package com.reviewer.elk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ElkApplication {

	public static void main(String[] args) {

		SpringApplication.run(ElkApplication.class, args);
	}

}