package com.junhua.tornesol.util.proxy.staticproxy;

public class Dog implements Animal{

    @Override
    public void eat() {
        System.out.println("吃肉");
    }

    @Override
    public void play() {
        System.out.println("play");
    }
}
