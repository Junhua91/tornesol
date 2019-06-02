package com.junhua.rpc.demo;

import java.lang.reflect.Method;

public class ClientDemo {

    public String say(String message) {
        return message;
    }


    public static void main(String[] args) {
        ClientDemo demo = new ClientDemo();

        Method[] methods = ClientDemo.class.getDeclaredMethods();

        for (Method method : methods) {
            String name = method.getName();


        }
    }
}
