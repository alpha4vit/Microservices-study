package by.gurinovich.clients.NotificationClient;

import by.gurinovich.clients.NotificationClient.response.Notification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient("NOTIFICATIONSERVICE")
public interface NotificationClient {

    @GetMapping
    List<Notification> getAll();

    @PostMapping
    Notification create(@RequestBody Notification notification);

}
