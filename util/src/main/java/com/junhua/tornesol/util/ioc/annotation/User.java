package com.junhua.tornesol.util.ioc.annotation;

@ExtService
public class User {

    @ExtAutowired
    private Order order;


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHi() {
        order.add();
    }
}
