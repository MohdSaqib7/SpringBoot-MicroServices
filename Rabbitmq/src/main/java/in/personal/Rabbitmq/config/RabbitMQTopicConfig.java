package in.personal.Rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

    @Value("${rabbitmq.exchange2.name}")
    private String exchangeName;

    @Value("${rabbitmq.queue1.name}")
    private String queue1;

    @Value("${rabbitmq.queue2.name}")
    private String queue2;

    @Value("${rabbitmq.routing.key1}")
    private String rountingKey1;

    @Value("${rabbitmq.routing.key2}")
    private String rountingKey2;


    @Bean
    public Queue queue1(){
        return new Queue(queue1);
    }
    @Bean
    public Queue queue2(){
        return new Queue(queue2);
    }
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchangeName);
    }
    @Bean
    public Binding bindingQueue1(){
        return BindingBuilder.bind(queue1()).to(exchange()).with(rountingKey1);
    }
    @Bean
    public Binding bindingQueue2(){
        return BindingBuilder.bind(queue2()).to(exchange()).with(rountingKey2);
    }
}
