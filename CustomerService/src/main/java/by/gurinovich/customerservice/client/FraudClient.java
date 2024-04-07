package by.gurinovich.customerservice.client;

import by.gurinovich.clients.FraudClient.response.FraudDto;

import java.util.UUID;

public interface FraudClient {

    Boolean checkIsCustomerFraud(UUID customerId);

    FraudDto save(FraudDto dto);

}
