package com.ximalaya.webgroup.tdkservice.mq;


import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
@RabbitListener(queues = "tdk.service.tests")
public class Receiver2 {

    Logger logger = LoggerFactory.getLogger(Receiver.class.getName());


    @RabbitHandler
    public void receiver(String msg, Channel channel, @Headers Map<String,Object> map) {
        logger.error("接收消息2：" + msg);

        try {
            if(map.get("error")!=null){
//                channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG),false,true);
                 channel.basicReject((Long)map.get(AmqpHeaders.DELIVERY_TAG),false);
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
