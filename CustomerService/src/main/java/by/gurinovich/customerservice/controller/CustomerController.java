package by.gurinovich.customerservice.controller;

import by.gurinovich.customerservice.entity.Customer;
import by.gurinovich.customerservice.service.CustomerService;
import by.gurinovich.customerservice.util.mapper.CustomerMapper;
import by.gurinovich.customerservice.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
public record CustomerController(
        CustomerService customerService,
        CustomerMapper customerMapper
) {


    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable("id") UUID id) {
        var customer = customerService.getById(id);
        return ResponseEntity.ok(customerMapper.toDto(customer));
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody CustomerDto customerDto){
        var saved = customerService.save(Customer.builder().username(customerDto.username()).build());
        return ResponseEntity.ok(saved);
    }
}
