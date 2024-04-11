package by.gurinovich.customerservice.client.impl;

import by.gurinovich.clients.FraudClient.FraudFeignClient;
import by.gurinovich.clients.FraudClient.response.FraudDto;
import by.gurinovich.clients.NotificationClient.NotificationClient;
import by.gurinovich.customerservice.client.FraudClient;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public record FraudClientImpl (
        FraudFeignClient fraudFeignClient,
        NotificationClient notificationClient
) implements FraudClient {

    @Override
    public Boolean checkIsCustomerFraud(UUID customerId) {
        return fraudFeignClient.checkIsCustomerFraud(customerId);
    }

    @Override
    public FraudDto save(FraudDto dto) {
        return fraudFeignClient.save(dto);
    }
}
