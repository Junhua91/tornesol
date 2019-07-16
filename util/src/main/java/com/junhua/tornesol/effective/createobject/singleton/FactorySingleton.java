package com.junhua.tornesol.effective.createobject.singleton;

import java.io.Serializable;

/**
 *
 */
public class FactorySingleton implements Serializable {

    //饿汉模式
    private static FactorySingleton INSTANCE = new FactorySingleton("junhua");

    private String name;

    private FactorySingleton(String name) {
        this.name = name;
    }


    public static FactorySingleton getInstance() {
        return INSTANCE;
    }


    private Object readResolve() {
        return INSTANCE;
    }
}
