package com.junhua.tornesol.util.ioc.xml;

public class User {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void add() {
        System.out.println(String.format("自定义容器[name:%s]", name));
    }
}
