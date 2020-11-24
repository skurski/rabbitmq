package com.rabbitmq.consumer.domain.service;

import com.rabbitmq.consumer.domain.model.Laptop;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * Alternative approach
 * Not active
 */
//@Component
@Slf4j
@RequiredArgsConstructor
public class AlternativeConsumerService {

//    private final RabbitTemplate rabbitTemplate;

    /**
     * Listen to queue and pull message when available
     */
    @RabbitListener(queues = "#{'${rabbit.queue.names}'.split(',')}" )
    public void receiveMessage(final Laptop message) {
        log.info("Received message: {}", message.toString());
    }

//    /**
//     * Alternative approach instead @RabbitListener, manually check queue every 5s
//     */
//    @Scheduled(fixedRate = 5000)
//    public void receive() {
//        Object object = rabbitTemplate.receiveAndConvert(HP_QUEUE_NAME);
//
//        if (null != object) {
//            Laptop product = (Laptop) object;
//            log.info("Received message: {}", product.toString());
//        }
//    }
}


