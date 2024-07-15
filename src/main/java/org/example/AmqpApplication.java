package org.example;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class AmqpApplication {
    public static void main(String[] args) {
        System.setProperty("https.protocols", "TLSv1 TLSv1.1 TLSv1.2 TLSv1.3");
        SpringApplication.run(AmqpApplication.class, args);

    }

    @Bean
    AmqpTest amqpTest(RabbitTemplate rabbitTemplate) {
        return new AmqpTest(rabbitTemplate);
    }


}
