package by.gurinovich.notificationservice.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Builder
@Document(collection = "notifications")
public class Notification {

    @Id
    private Long id;

    private String issuer;

    private String body;

    @CreatedDate
    private Instant creationTime;

}
