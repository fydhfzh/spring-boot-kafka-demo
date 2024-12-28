package com.kafka.tutorial;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private final String topicName = "logs";

    @PostMapping
    public void publish(@RequestBody MessageRequest messageRequest) {
        System.out.println(System.currentTimeMillis());
        kafkaTemplate.send(topicName, messageRequest.message());
    }
}
