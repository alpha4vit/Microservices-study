package by.gurinovich.notificationservice.listener;

import by.gurinovich.notificationservice.entity.Notification;
import by.gurinovich.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationListener {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consume(Notification notification){
        log.info("NotificationService consumes {}", notification);
        notificationService.save(notification);
    }

}
