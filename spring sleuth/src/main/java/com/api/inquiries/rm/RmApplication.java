package com.api.inquiries.rm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RmApplication {

	public static void main(String[] args) {
		SpringApplication.run(RmApplication.class, args);
	}

}
