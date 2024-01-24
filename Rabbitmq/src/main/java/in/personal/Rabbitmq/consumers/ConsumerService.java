package in.personal.Rabbitmq.consumers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {

    @RabbitListener(queues={"${rabbitmq.queue.name}"})
    public void consumeFanoutQueue(String message){
        log.info(String.format("Message Received from Fanout attached queue --> %s",message));
    }

    @RabbitListener(queues={"${rabbitmq.queue1.name}"})
    public void consumeTopicQueue1(String message){
        log.info(String.format("Message Received from Queue1 --> %s",message));
    }

    @RabbitListener(queues={"${rabbitmq.queue2.name}"})
    public void consumeTopicQueue2(String message){
        log.info(String.format("Message Received from Queue2 --> %s",message));
    }

}
