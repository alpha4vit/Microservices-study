package by.gurinovich.notificationservice.service.impl;

import by.gurinovich.notificationservice.entity.Notification;
import by.gurinovich.notificationservice.exception.NotFoundException;
import by.gurinovich.notificationservice.repository.NotificationRepository;
import by.gurinovich.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;


    @Override
    public Notification getById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Notification with this id not found!"));
    }

    @Override
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    @Override
    public List<Notification> getByIssuer(String issuer) {
        return notificationRepository.findByIssuer(issuer);
    }

    @Override
    public List<Notification> getByTimePeriod(Instant from, Instant to) {
        return notificationRepository.findByCreationTimeAfterAndCreationTimeBefore(from, to);
    }

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }
}
