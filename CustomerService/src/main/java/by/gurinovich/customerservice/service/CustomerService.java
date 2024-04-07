package by.gurinovich.customerservice.service;

import by.gurinovich.customerservice.entity.Customer;

import java.util.UUID;

public interface CustomerService {

    Customer getById(UUID id);

    Customer save(Customer customer);
}
