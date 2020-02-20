package com.nalaolla.rabbitmq;


import org.junit.jupiter.api.Test;
import org.springframework.amqp.AmqpConnectException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class RabbitmqApplicationTests {

    @MockBean
    private Runner runner;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Receiver receiver;

    @Test
    public void test() throws Exception {
        try {
            rabbitTemplate.convertAndSend(RabbitmqApplication.queueName,
                    "Hello from RabbitMQ RabbitmqApplicationTests!");
            receiver.getCountDownLatch().await(10000, TimeUnit.MILLISECONDS);
        }
        catch (AmqpConnectException e) {
            // ignore - rabbit is not running
        }
    }

}
