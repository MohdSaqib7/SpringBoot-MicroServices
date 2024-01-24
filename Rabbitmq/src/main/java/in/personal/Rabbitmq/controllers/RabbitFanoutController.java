package in.personal.Rabbitmq.controllers;

import in.personal.Rabbitmq.publishers.SingleQueueProducerApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitFanoutController {

    @Autowired
    private SingleQueueProducerApp singleQueueProducerApp;

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam String message){
        singleQueueProducerApp.passMessage(message);
        return ResponseEntity.ok("Successfully sent");
    }

}
