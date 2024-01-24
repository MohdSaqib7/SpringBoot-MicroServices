package in.personal.Rabbitmq.controllers;

import in.personal.Rabbitmq.publishers.MultipleQueueProducerApp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitTopicController {

    private MultipleQueueProducerApp multipleQueueProducerApp;

    @GetMapping("/queue1")
    public String passMessageToQueue1(@RequestParam String message){
        multipleQueueProducerApp.passMessageToQueue1(message);
        return "Successfully sent to queue1";
    }

    @GetMapping("/queue2")
    public String passMessageToQueue2(@RequestParam String message){
        multipleQueueProducerApp.passMessageToQueue2(message);
        return "Successfully sent to queue2";
    }
}
