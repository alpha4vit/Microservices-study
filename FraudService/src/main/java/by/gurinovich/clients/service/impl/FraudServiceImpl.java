package by.gurinovich.clients.service.impl;


import by.gurinovich.clients.entity.Fraud;
import by.gurinovich.clients.repository.FraudRepository;
import by.gurinovich.clients.service.FraudService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public record FraudServiceImpl(
        FraudRepository fraudRepository
) implements FraudService {

    @Override
    public Boolean isFraudster(UUID customerId) {
        var customer = fraudRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Record for this customer not found!"));
        return customer.getIsFraud();
    }

    @Override
    public Fraud save(Fraud fraud) {
        return fraudRepository.save(fraud);
    }

}
