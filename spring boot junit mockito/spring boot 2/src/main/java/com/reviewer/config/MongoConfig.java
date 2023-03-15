package com.reviewer.config;

import com.reviewer.dao.UserRepository;
import com.reviewer.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return strings -> {
            userRepository.save(new User("1", "Matthew", "Frazier"));
            userRepository.save(new User("2", "Nyasia", "Hubbard"));
            userRepository.save(new User("3", "Randall", "Forbes"));
            userRepository.save(new User("4", "Allison", "Carney"));
            userRepository.save(new User("5", "Maxim", "Hampton"));
        };
    }
}
