package com.junhua.tornesol.effective.createobject.singleton;


/**
 * 不用担心Serialize的问题
 */
public enum EnumSingleton {

    JUNHUA("junhua", 18), LELE("lele", 18);

    private String name;
    private int age;

    EnumSingleton(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


