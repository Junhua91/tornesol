package com.junhua.tornesol.util.spring.spring_lifecycle;

import org.springframework.beans.factory.annotation.Value;

public class Animal {

    @Value("black")
    private String color;

    @Value("#{2+1}")
    private int age;

    @Value("${nickname}")//配置文件中的key
    private String nickname;

    @Override
    public String toString() {
        return String.format("{color:%s, age:%s, nickname:%s}", color, age, nickname);
    }
}
