package com.xwei.springbootrabbitmqdemo.controller;

import com.xwei.springbootrabbitmqdemo.dto.User;
import com.xwei.springbootrabbitmqdemo.publisher.RabbitMQJsonProducer;
import com.xwei.springbootrabbitmqdemo.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class MessageController {
    private final RabbitMQProducer producer;

    public MessageController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    // http://localhost:8090/api/v1/publish?message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        producer.sendMessage(message);
        return ResponseEntity.ok("Message send to RabbitMQ ...");
    }


}
