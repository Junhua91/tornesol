package com.junhua.tornesol.util.spring.spring_lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Student {

    public Student() {
        System.out.println("student constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("student init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("student destroy");

    }
}
