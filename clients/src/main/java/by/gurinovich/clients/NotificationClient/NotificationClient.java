package by.gurinovich.clients.NotificationClient;

import by.gurinovich.clients.NotificationClient.response.Notification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(value = "NOTIFICATIONSERVICE")
public interface NotificationClient {

    @GetMapping("api/v1/notifications")
    List<Notification> getAll();

    @PostMapping("api/v1/notifications")
    Notification create(@RequestBody Notification notification);

}
