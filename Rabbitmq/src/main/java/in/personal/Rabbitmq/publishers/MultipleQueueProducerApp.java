package in.personal.Rabbitmq.publishers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MultipleQueueProducerApp {

    @Value("${rabbitmq.exchange2.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key1}")
    private String routingKey1;

    @Value("${rabbitmq.routing.key2}")
    private String routingKey2;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Async
    public void passMessageToQueue1(String message){
        rabbitTemplate.convertAndSend(exchangeName,routingKey1,message);
    }
    @Async
    public void passMessageToQueue2(String message){
        rabbitTemplate.convertAndSend(exchangeName,routingKey2,message);
    }
}
