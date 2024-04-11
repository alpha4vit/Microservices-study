package by.gurinovich.clients.service.impl;


import by.gurinovich.clients.NotificationClient.NotificationClient;
import by.gurinovich.clients.NotificationClient.response.Notification;
import by.gurinovich.clients.entity.Fraud;
import by.gurinovich.clients.repository.FraudRepository;
import by.gurinovich.clients.service.FraudService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public record FraudServiceImpl(
        FraudRepository fraudRepository,
        NotificationClient notificationClient
) implements FraudService {

    @Override
    public Boolean isFraudster(UUID customerId) {
        return fraudRepository.findByCustomerId(customerId)
                .map(customer -> {
                    if (customer.getIsFraud()) {
                        notificationClient.create(
                                Notification.builder()
                                        .body(String.format("Customer with id %s is fraudster!", customerId))
                                        .issuer("FraudService")
                                        .build());
                    }
                    log.info("Customer with id {} is fraudster", customerId);
                    return customer.getIsFraud();
                })
                .orElseThrow(() -> new EntityNotFoundException("Record for this customer not found!"));
    }


    @Override
    public Fraud save(Fraud fraud) {
        return fraudRepository.save(fraud);
    }

}
