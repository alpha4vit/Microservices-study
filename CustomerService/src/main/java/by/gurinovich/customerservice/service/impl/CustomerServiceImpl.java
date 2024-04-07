package by.gurinovich.customerservice.service.impl;

import by.gurinovich.clients.FraudClient.response.FraudDto;
import by.gurinovich.customerservice.client.FraudClient;
import by.gurinovich.customerservice.entity.Customer;
import by.gurinovich.customerservice.repository.CustomerRepository;
import by.gurinovich.customerservice.service.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public record CustomerServiceImpl(
        CustomerRepository customerRepository,
        FraudClient fraudClient
) implements CustomerService {

    @Override
    public Customer getById(UUID id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with this id not found!"));
    }

    @Override
    public Customer save(Customer customer) {
        var saved = customerRepository.save(customer);
        var response = fraudClient.save(
                FraudDto.builder()
                        .customerId(saved.getId())
                        .isFraud(false)
                        .build()
        );
        log.info(response.toString());
        return saved;
    }




}
