package com.junhua.tornesol.util.spring.spring_event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        UserService user = context.getBean(UserService.class);
        user.insert();
    }

}
