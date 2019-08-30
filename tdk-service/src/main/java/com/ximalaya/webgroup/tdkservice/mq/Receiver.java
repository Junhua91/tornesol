package com.ximalaya.webgroup.tdkservice.mq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "tdk.service.test")
public class Receiver {

    Logger logger = LoggerFactory.getLogger(Receiver.class.getName());


    @RabbitHandler
    public void process(String str) {

        logger.error("接收消息1：" + str);
    }
}
