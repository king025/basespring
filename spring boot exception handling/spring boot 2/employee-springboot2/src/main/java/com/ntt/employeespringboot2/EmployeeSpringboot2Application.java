package com.ntt.employeespringboot2;

import com.ntt.employeespringboot2.dao.EmployeesRepository;
import com.ntt.employeespringboot2.enums.Status;
import com.ntt.employeespringboot2.models.Employees;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class EmployeeSpringboot2Application {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSpringboot2Application.class, args);
	}



}
