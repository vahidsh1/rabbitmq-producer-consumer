package com.example.digipayconsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class DigipayConsumer {
    @RabbitListener(queues = "digipay.queue")
    public void listen(String in){
        System.out.println(" dDSDsdsD******"+ in);
    }
}
