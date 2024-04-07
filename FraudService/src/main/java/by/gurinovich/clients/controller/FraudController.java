package by.gurinovich.clients.controller;

import by.gurinovich.clients.FraudClient.response.FraudDto;
import by.gurinovich.clients.service.FraudService;
import by.gurinovich.clients.util.mapper.FraudMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/fraud")
public record FraudController(
        FraudService fraudService,
        FraudMapper fraudMapper
) {

    @GetMapping("/{customerId}")
    public ResponseEntity<Boolean> checkIsCustomerFraud(@PathVariable("customerId") UUID customerId){
        return ResponseEntity.ok(fraudService.isFraudster(customerId));
    }

    @PostMapping
    public ResponseEntity<FraudDto> save(@RequestBody FraudDto fraudDto){
        var saved = fraudService.save(fraudMapper.toEntity(fraudDto));
        return ResponseEntity.ok(fraudMapper.toDto(saved));
    }

}
