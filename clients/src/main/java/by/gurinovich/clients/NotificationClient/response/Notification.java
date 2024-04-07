package by.gurinovich.clients.NotificationClient.response;

import java.time.Instant;

public record Notification(
        Long id,
        String issuer,
        String body,
        Instant creationTime
){
}
