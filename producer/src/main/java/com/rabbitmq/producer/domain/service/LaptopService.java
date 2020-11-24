package com.rabbitmq.producer.domain.service;

import com.rabbitmq.producer.domain.model.Laptop;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class LaptopService {

    private static final String TOPIC_EXCHANGE_NAME = "laptops_exchange";

    private final RabbitTemplate rabbitTemplate;

    public Mono<Laptop> save(Laptop laptop) {
        log.info("Sending message: {}", laptop);

        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, laptop.getKey(), laptop);

        return Mono.just(laptop);
    }
}
