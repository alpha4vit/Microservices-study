package by.gurinovich.clients.FraudClient.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record FraudDto(
        Long id,
        UUID customerId,
        Boolean isFraud
) {
}
