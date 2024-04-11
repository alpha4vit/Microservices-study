package by.gurinovich.clients.NotificationClient.response;

import lombok.Builder;

import java.time.Instant;

@Builder
public record Notification(
        String id,
        String issuer,
        String body,
        Instant creationTime
){
}
