package in.personal.Rabbitmq.publishers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SingleQueueProducerApp {

    @Value("${rabbitmq.exchange1.name}")
    private String exchangeName;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Async
    public void passMessage(String message){
        rabbitTemplate.convertAndSend(exchangeName,"", message);
    }

}
