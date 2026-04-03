package com.example.notificationservice.serivce.listener;

import com.example.architecture.dto.UserCreatedEvent;
import com.example.notificationservice.serivce.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EventConsumerListener {

    private final NotificationService notificationService;

    public EventConsumerListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "user.events")
    public void handleUserEvent(UserCreatedEvent event) {
        notificationService.sendNotification(event);
    }

}
