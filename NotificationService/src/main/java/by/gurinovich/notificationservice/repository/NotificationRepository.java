package by.gurinovich.notificationservice.repository;

import by.gurinovich.notificationservice.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, Long> {
    List<Notification> findByIssuer(String issuer);
    List<Notification> findByCreationTimeAfterAndCreationTimeBefore(Instant from, Instant to);
}
