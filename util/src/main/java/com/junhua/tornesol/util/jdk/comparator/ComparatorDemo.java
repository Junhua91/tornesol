package com.junhua.tornesol.util.jdk.comparator;

import java.util.ArrayList;
import java.util.List;

public class ComparatorDemo {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            Person person = new Person("person" + i, i);
            personList.add(person);
        }

        personList.stream().sorted().forEach(p -> System.out.println(p));

    }
}
