package com.ximalaya.webgroup.tdkservice.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqTopicConfig {

    final static String test = "tdk.service.test";
    final static String tests = "tdk.service.tests";

    Logger logger = LoggerFactory.getLogger(Receiver.class.getName());


    @Bean
    public Queue testQueue() {
        return new Queue(RabbitMqTopicConfig.test);
    }

    @Bean
    public Queue testsQueue() {
        return new Queue(RabbitMqTopicConfig.tests);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue testQueue, TopicExchange exchange) {
        return BindingBuilder.bind(testQueue).to(exchange).with("tdk.test2");
    }


    @Bean
    Binding bindingExchangeMessages(Queue testsQueue, TopicExchange exchange) {
        return BindingBuilder.bind(testsQueue).to(exchange).with("tdk.#");
    }

//    @Bean
//    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//
//        container.setQueueNames(tests);
//        container.setAcknowledgeMode(AcknowledgeMode.NONE);
//
//        container.setMessageListener(message -> {
//            logger.error("====接收到消息=== " + new String(message.getBody()));
//            int a = 1 / 0;
//        });
//        return container;
//    }
}
