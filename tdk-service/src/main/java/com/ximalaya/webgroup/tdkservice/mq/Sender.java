package com.ximalaya.webgroup.tdkservice.mq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender implements InitializingBean {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    Logger logger = LoggerFactory.getLogger(Receiver.class.getName());


    public String send() {
        MessagePostProcessor processor = (message) -> {
            message.getMessageProperties().setHeader("error", "this is a error message");
            return message;
        };
        rabbitTemplate.convertAndSend("exchange", "tdk.junhua", "测试消息1",processor);
        //rabbitTemplate.convertAndSend("exchange", "tdk.service.tests","测试消息2");
        return "success";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.error("sender init...");
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (!ack)
                logger.error(correlationData + " send message failed...");
            else logger.error(correlationData + " send message successfully");
        });

        rabbitTemplate.setReturnCallback((message, replyCode, replyText,
                                          exchange, routingKey) -> {
            logger.error("test " + routingKey);
        });
    }
}
