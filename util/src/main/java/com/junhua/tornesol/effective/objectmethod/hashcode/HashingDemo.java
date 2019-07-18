package com.junhua.tornesol.effective.objectmethod.hashcode;

import com.junhua.tornesol.effective.objectmethod.Person;

public class HashingDemo {


    public static void main(String[] args) {

        Person person = new Person(20, "junhua");
        Person person2 = new Person(21, "junhua1");
        Person person3 = new Person(22, "junhua2");

        System.out.println(person.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person3.hashCode());

    }
}
