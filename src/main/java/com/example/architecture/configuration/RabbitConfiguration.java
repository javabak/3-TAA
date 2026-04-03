package com.example.architecture.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    public static final String USER_QUEUE = "user.events";
    public static final String USER_EXCHANGE = "user.exchange";
    public static final String USER_ROUTING_KEY = "user.#";

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue queue() {
        return new Queue(USER_QUEUE, true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(USER_EXCHANGE);
    }

    @Bean
    public Binding binding(Queue userQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(userQueue).to(topicExchange).with(USER_ROUTING_KEY);
    }
}
