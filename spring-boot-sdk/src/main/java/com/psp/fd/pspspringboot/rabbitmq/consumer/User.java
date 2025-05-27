package com.psp.fd.pspspringboot.rabbitmq.consumer;

import com.psp.fd.pspspringboot.rabbitmq.config.MessagingConfig;
import com.psp.fd.pspspringboot.rabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message recieved from queue : " + orderStatus);
    }
}
