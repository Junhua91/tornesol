package com.junhua.tornesol.effective.createobject.builder.one;

public class Demo {

    public static void main(String[] args) {
        Person.Builder builder = new Person.Builder("junhua", "male").age("27");
        Person person = builder.build();
    }
}
