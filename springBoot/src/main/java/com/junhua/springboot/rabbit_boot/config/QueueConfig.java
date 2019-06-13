package com.junhua.springboot.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean(name = "direct_queue")
    public Queue direct_queue() {
        return new Queue("test_queue");
    }

    @Bean(name = "topic_queue1")
    public Queue topic_queue_1() {
        return new Queue("topic.queue.1");
    }

    @Bean(name = "topic_queue2")
    public Queue topic_queue_2() {
        return new Queue("topic.queue.2");
    }

    @Bean(name = "fanout_queue")
    public Queue fanout_queue() {
        return new Queue("fanout.queue.1");
    }

    @Bean(name = "fanout_queue2")
    public Queue fanout_queue_2() {
        return new Queue("fanout.queue.2");
    }

    @Bean(name = "fanout_queue3")
    public Queue fanout_queue_3() {
        return new Queue("fanout.queue.3");
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("topic_exchange");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout_exchange");
    }

    @Bean
    public Binding bindingExchangeMessage1(@Qualifier("topic_queue1") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("topic.queue.test");
    }

    @Bean
    public Binding bindingExchangeMessage2(@Qualifier("topic_queue2") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("topic.queue.*");
    }

    @Bean
    public Binding fanoutBindingExchangeMessage1(@Qualifier("fanout_queue") Queue queue, FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    public Binding fanoutBindingExchangeMessage2(@Qualifier("fanout_queue2") Queue queue, FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    public Binding fanoutBindingExchangeMessage3(@Qualifier("fanout_queue3") Queue queue, FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

}
