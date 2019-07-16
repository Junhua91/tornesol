package com.junhua.tornesol.effective.createobject.builder.multi.animal;

public class Animaldemo {

    public static void main(String[] args) {
        Cat cat = new Cat.Builder("fish", "抓老鼠").setMiao("miaomiao").build();
        Dog dog = new Dog.Builder("bone", "拆家").setWang("wangwang").build();

        cat.doAction();
        dog.doAction();
    }
}
