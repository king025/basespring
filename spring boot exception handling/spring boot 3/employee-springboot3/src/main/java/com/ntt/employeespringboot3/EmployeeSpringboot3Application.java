package com.ntt.employeespringboot3;

import com.ntt.employeespringboot3.dao.EmployeesRepository;
import com.ntt.employeespringboot3.models.Employees;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class EmployeeSpringboot3Application {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSpringboot3Application.class, args);
	}

	
}
