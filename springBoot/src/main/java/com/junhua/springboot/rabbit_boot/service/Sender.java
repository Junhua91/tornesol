package com.junhua.springboot.rabbit_boot.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private RabbitTemplate template;
    public void send(String message) {
        //direct 方式
        template.convertAndSend("test_queue", message);
        //topic 方式
        template.convertAndSend("topic_exchange", "topic.queue.test", message + "_topic_exchange_test");
        template.convertAndSend("topic_exchange", "topic.queue.1", message + "_topic_exchange");
        //fanout方式
        template.convertAndSend("fanout_exchange", "", message + "_fanout_exchange");
    }
}
