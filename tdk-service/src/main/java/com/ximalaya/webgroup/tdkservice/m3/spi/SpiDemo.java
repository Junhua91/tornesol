package com.ximalaya.webgroup.tdkservice.m3.spi;

import java.util.ServiceLoader;

public class SpiDemo {

    public static void main(String[] args) {
        ServiceLoader<Person> persons = ServiceLoader.load(Person.class);
        for (Person p : persons) {
            p.getMetier();
        }
    }
}
