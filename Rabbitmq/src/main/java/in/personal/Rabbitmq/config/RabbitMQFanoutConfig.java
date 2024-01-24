package in.personal.Rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQFanoutConfig {

    @Value("${rabbitmq.exchange1.name}")
    private String exchangeName;

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    @Bean
    public FanoutExchange exchange(){
        return new FanoutExchange(exchangeName);
    }
    @Bean
    public Queue queue(){
        return new Queue(queueName);
    }
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(exchange());
    }
}
