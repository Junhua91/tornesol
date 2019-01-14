package com.junhua.tornesol.util.spring.spring_listener;


import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ListenerDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

        context.publishEvent(new MyApplicationEvent(new String("event")) {
        });

    }


}
