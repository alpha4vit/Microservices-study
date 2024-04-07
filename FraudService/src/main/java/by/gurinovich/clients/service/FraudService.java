package by.gurinovich.clients.service;

import by.gurinovich.clients.entity.Fraud;

import java.util.UUID;

public interface FraudService {

    Boolean isFraudster(UUID customerId);

    Fraud save(Fraud fraud);

}
