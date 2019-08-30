package com.ximalaya.webgroup.tdkservice.m3.proxy;

public class PersonImpl implements Person {

    @Override
    public void say(String msg) {
        System.out.println("hi "+ msg);
    }
}
