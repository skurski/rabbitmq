package com.rabbitmq.consumer.domain.service;

import com.rabbitmq.consumer.domain.model.Laptop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RabbitListener(queues = "#{'${rabbit.queue.names}'.split(',')}" )
public class ConsumerService {

    @RabbitHandler
    public void receiveMessage(Laptop message) {
        log.info("Received message: {}", message.toString());
    }
}