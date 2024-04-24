package by.gurinovich.fraudservice.service.impl;


import by.gurinovich.clients.NotificationClient.NotificationClient;
import by.gurinovich.fraudservice.entity.Fraud;
import by.gurinovich.fraudservice.repository.FraudRepository;
import by.gurinovich.fraudservice.service.FraudService;
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
        var fraud = fraudRepository.findByCustomerId(customerId)
                .orElse(Fraud.builder().isFraud(false).build());
        return fraud.getIsFraud();
    }


    @Override
    public Fraud save(Fraud fraud) {
        return fraudRepository.save(fraud);
    }

}
