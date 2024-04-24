package by.gurinovich.fraudservice.controller;

import by.gurinovich.clients.FraudClient.response.FraudDto;
import by.gurinovich.fraudservice.service.FraudService;
import by.gurinovich.fraudservice.util.mapper.FraudMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public record FraudController(
        FraudService fraudService,
        FraudMapper fraudMapper
) {

    @RequestMapping("/map")
    public String map(@RequestBody SampleObject sampleObject){
        return sampleObject.b + sampleObject.c;
    }

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

class SampleObject{
    public String c;
    public String b;
}
