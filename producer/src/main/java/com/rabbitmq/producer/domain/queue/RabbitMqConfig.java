package com.rabbitmq.producer.domain.queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    private static final String TOPIC_EXCHANGE_NAME = "laptops_exchange";

    private static final String HP_QUEUE_NAME = "hp_laptops_queue";

    private static final String DELL_QUEUE_NAME = "dell_laptops_queue";

    private static final String LENOVO_QUEUE_NAME = "lenovo_laptops_queue";

    private static final String GENERAL_QUEUE = "general_laptops_queue";

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME, true, false);
    }

    @Bean
    public Queue hpQueue() {
        return new Queue(HP_QUEUE_NAME, true);
    }

    @Bean
    public Queue dellQueue() {
        return new Queue(DELL_QUEUE_NAME, true);
    }

    @Bean
    public Queue lenovoQueue() {
        return new Queue(LENOVO_QUEUE_NAME, true);
    }

    @Bean
    public Queue generalQueue() {
        return new Queue(GENERAL_QUEUE, true);
    }

    @Bean
    public Binding hpBinding(TopicExchange exchange) {
        return BindingBuilder.bind(hpQueue()).to(exchange).with("hp.laptops.*");
    }

    @Bean
    public Binding dellBinding(TopicExchange exchange) {
        return BindingBuilder.bind(dellQueue()).to(exchange).with("dell.laptops.*");
    }

    @Bean
    public Binding lenovoBinding(TopicExchange exchange) {
        return BindingBuilder.bind(lenovoQueue()).to(exchange).with("lenovo.laptops.*");
    }

    @Bean
    public Binding generalBinding(TopicExchange exchange) {
        return BindingBuilder.bind(generalQueue()).to(exchange).with("*.laptops.#");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
}
