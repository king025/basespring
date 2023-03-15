package com.ntt.demoSpring2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoSpring2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpring2Application.class, args);
	}


}
