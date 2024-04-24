package by.gurinovich.amqp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate rabbitTemplate;

    public void publish(Object payload, String exchange, String routingKey){
        log.info("Publishing {} to exchange {} with {}", payload, exchange, routingKey);
        rabbitTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("Published {} to exchange {} with {}", payload, exchange, routingKey);
    }

}
