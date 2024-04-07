package by.gurinovich.clients.FraudClient;

import by.gurinovich.clients.FraudClient.response.FraudDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient("FRAUDSERVICE")
public interface FraudFeignClient {

    @GetMapping("api/v1/fraud/{customerId}")
    Boolean checkIsCustomerFraud(@PathVariable("customerId") UUID customerId);

    @PostMapping("api/v1/fraud")
    FraudDto save(@RequestBody FraudDto fraudDto);

}
