package com.reviewer.config;

import com.reviewer.dao.ProductRepository;
import com.reviewer.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = ProductRepository.class)
@Configuration
public class MongoConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return strings -> {
            productRepository.save(new Product("1", "Soap", 5, 50.00));
            productRepository.save(new Product("2", "Shampoo", 8, 30.00));
            productRepository.save(new Product("3", "Toothpaste", 4, 100.00));
            productRepository.save(new Product("4", "Tooth Brush", 2, 80.00));
            productRepository.save(new Product("5", "Conditioner", 7, 40.00));
        };
    }
}
