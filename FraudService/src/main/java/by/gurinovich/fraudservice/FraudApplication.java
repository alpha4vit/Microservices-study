package by.gurinovich.fraudservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "by.gurinovich.clients")
@EnableDiscoveryClient
@SpringBootApplication
public class FraudApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(FraudApplication.class, args);
    }
}
