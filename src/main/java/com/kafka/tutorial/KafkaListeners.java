package com.kafka.tutorial;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "logs", groupId = "groupId")
    void listener(String data) {
        System.out.println(System.currentTimeMillis());
        System.out.println("Listener received: " + data + " SKIBIDI!");
    }
}
