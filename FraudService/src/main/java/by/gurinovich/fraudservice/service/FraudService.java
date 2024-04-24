package by.gurinovich.fraudservice.service;

import by.gurinovich.fraudservice.entity.Fraud;

import java.util.UUID;

public interface FraudService {

    Boolean isFraudster(UUID customerId);

    Fraud save(Fraud fraud);

}
