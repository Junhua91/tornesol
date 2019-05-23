package com.junhua.tornesol.util.proxy.dynamic;

import com.junhua.tornesol.util.proxy.staticproxy.Animal;
import com.junhua.tornesol.util.proxy.staticproxy.Dog;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicDemo {


    static public void main(String[] args) {

        Animal dog = new Dog();

        InvocationHandler dogHandler = new MyInvocationHandler<Animal>(dog);

        Animal animalProxy = (Animal) Proxy.newProxyInstance(Animal.class.getClassLoader(),
                new Class<?>[]{Animal.class}, dogHandler);

        animalProxy.eat();

        animalProxy.play();
    }

}
