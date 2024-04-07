package by.gurinovich.notificationservice.controller;

import by.gurinovich.notificationservice.entity.Notification;
import by.gurinovich.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<Notification>> getAll(){
        return ResponseEntity.ok(notificationService.getAll());
    }

    @PostMapping
    public ResponseEntity<Notification> create(@RequestBody Notification notification){
        return ResponseEntity.ok(notificationService.save(notification));
    }

}
