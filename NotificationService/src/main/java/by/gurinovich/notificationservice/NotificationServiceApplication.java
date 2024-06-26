package by.gurinovich.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableFeignClients
@EnableMongoAuditing
@EnableDiscoveryClient
@SpringBootApplication
@EnableMongoRepositories
public class NotificationServiceApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }
}
