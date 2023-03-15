package com.example.demo;

// Importing required classes

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component

// Class
public class KafkaConsumer {

    @KafkaListener(topics = "NewTopic",
            groupId = "group_id")


    public void
    consume(String message) {
        // Print statement
        System.out.println("message = " + message);
    }
}
