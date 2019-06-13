package com.junhua.springboot.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    Logger logger = LoggerFactory.getLogger(Receiver.class.getName());

    @RabbitListener(queues = "test_queue")
    public void process1(String message) {
        logger.info(message);
    }

    @RabbitListener(queues = "topic.queue.1")
    public void process2(String message) {
        logger.info("topic.queue.1_" + message);
    }

    @RabbitListener(queues = "topic.queue.2")
    public void process3(String message) {
        logger.info("topic.queue.2_" + message);
    }

    @RabbitListener(queues = "fanout.queue.1")
    public void process4(String message) {
        logger.info("fanout.queue.1_" + message);
    }


    @RabbitListener(queues = "fanout.queue.2")
    public void process5(String message) {
        logger.info("fanout.queue.2_" + message);
    }

    @RabbitListener(queues = "fanout.queue.3")
    public void process6(String message) {
        logger.info("fanout.queue.3_" + message);
    }
}
