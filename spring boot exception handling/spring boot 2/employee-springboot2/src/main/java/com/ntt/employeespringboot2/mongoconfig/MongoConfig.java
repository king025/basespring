package com.ntt.employeespringboot2.mongoconfig;

import com.ntt.employeespringboot2.dao.EmployeesRepository;
import com.ntt.employeespringboot2.models.Employees;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = EmployeesRepository.class)
@Configuration
public class MongoConfig {
    @Bean
    CommandLineRunner runner(EmployeesRepository repository, MongoTemplate mongoTemplate ){
        return args -> {


            Employees employees = new Employees(
                    "Ryzen Paquibot",
                    "Developer",
                    "ryzen.paquibot@global.ntt.com",
                    "Web"
            );
            repository.findEmployeesByEmail(employees.getEmail())
                    .ifPresentOrElse(e -> System.out.println(e + "already exists"),()->{
                        System.out.println("Inserting employees " + employees);
                        repository.insert(employees);
                    });

        };
    }

}
