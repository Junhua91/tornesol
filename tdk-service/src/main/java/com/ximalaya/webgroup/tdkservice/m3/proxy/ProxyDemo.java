package com.ximalaya.webgroup.tdkservice.m3.proxy;

import java.lang.reflect.Proxy;

public class ProxyDemo {


    public static void main(String[] args) {
        Person person = new PersonImpl();

        MyInvocationHandler<Person> personMyInvocationHandler = new MyInvocationHandler<>();
        personMyInvocationHandler.setTarget(person);

        Person personProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),
                new Class<?>[]{Person.class}, personMyInvocationHandler);


        person.say("lele");
        personProxy.say("junhua");
    }
}
