package com.example.digipayproducer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import java.util.Queue;

@Configuration
public class RabbitMQConfig {
    @Value("rabbitmq.queue")
    String queueName;
    @Value("rabbitmq.exchange")
    String exchange;
    @Value("rabbitmq.routingKey")
    private String routingKey;

    @Bean
    Queue queue() {
        return new Queue("digipay.queue", true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }
}
