package by.gurinovich.notificationservice.service;

import by.gurinovich.notificationservice.entity.Notification;

import java.time.Instant;
import java.util.List;

public interface NotificationService {

    Notification getById(Long id);

    List<Notification> getAll();

    List<Notification> getByIssuer(String issuer);

    List<Notification> getByTimePeriod(Instant from, Instant to);

    Notification save(Notification notification);

}
