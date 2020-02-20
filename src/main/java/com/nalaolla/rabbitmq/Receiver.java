package com.nalaolla.rabbitmq;

import org.springframework.stereotype.Component;
import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("receive message : " + message);
        countDownLatch.countDown();
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }
}
