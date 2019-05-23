package com.junhua.tornesol.util.proxy.staticproxy;

public class DogProxy implements Animal {

    Dog dog;

    public DogProxy(Animal animal) {

        if (animal.getClass() == Dog.class) {
            this.dog = (Dog) animal;
        }
    }

    @Override
    public void eat() {
        System.out.println("hahaha");
        dog.eat();
    }

    @Override
    public void play() {
        System.out.println("play");
        dog.play();
    }
}
