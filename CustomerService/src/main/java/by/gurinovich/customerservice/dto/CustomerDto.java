package by.gurinovich.customerservice.dto;

import java.util.UUID;

public record CustomerDto(
        UUID id,
        String username
) {
}
