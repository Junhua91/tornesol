package com.junhua.tornesol.effective.jdk.base;

public class DefaultValueDemo {

    public static class Person {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {


        Person person = new Person();

        System.out.println(person.getAge());
        System.out.println(person.getName());

    }
}
