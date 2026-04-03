package com.example.architecture.service.publisher;

import com.example.architecture.configuration.RabbitConfiguration;
import com.example.architecture.dto.UserCreatedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public UserEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishUserEvent(UserCreatedEvent event) {
        rabbitTemplate.convertAndSend(
                RabbitConfiguration.USER_EXCHANGE,
                "user.created",
                event
        );
    }
}
