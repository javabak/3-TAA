package com.example.notificationservice.serivce;

import com.example.architecture.dto.UserCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class NotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);

    public void sendNotification(UserCreatedEvent notification) {
        LOGGER.info("user created: {}", notification);

        // симулирует долгий (10 секунд) ответ сервиса
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            LOGGER.info("sleep interrupted");
        }
    }

}
