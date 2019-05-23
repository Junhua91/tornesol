package com.junhua.tornesol.util.proxy.staticproxy;

public class Demo {

    public static void main(String[] args) {

        Animal animal = new Dog();

        Animal monitor = new DogProxy(animal);

        monitor.eat();
    }
}
