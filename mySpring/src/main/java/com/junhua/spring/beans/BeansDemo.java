package com.junhua.spring.beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeansDemo {

    static public void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        context.getBean(MathCalculator.class);
    }

}
