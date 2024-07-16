package org.example;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class AmqpTest {

    Logger logger = LoggerFactory.getLogger(AmqpTest.class);

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public AmqpTest(
            RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        logger.info("AmqpTest created");
    }

    @PostConstruct
    void init() {
        logger.info("AmqpTest init");
        rabbitTemplate.convertAndSend("source-queue", "", new String("Test").getBytes(StandardCharsets.UTF_8), m -> {
            m.getMessageProperties().setPriority(null);
            return m;
        });
    }
}
