package by.gurinovich.apigw;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayService
{
    public static void main( String[] args )
    {
        SpringApplication.run(ApiGatewayService.class, args);
    }
}
