package com.junhua.tornesol.effective.createobject.singleton;


import java.io.Serializable;

/**
 * 兼顾了懒汉模式和饿汉模式的有点：没有阻塞代码；没有立即加载
 * <p>
 * 1. 饿汉：没有添加synchronize；jvm只会加载一次static成员
 * 2. 懒汉：静态内部类只有在用到的时候，才会被加载
 */
public class StaticInnerSingleton implements Serializable {

    private StaticInnerSingleton() {
    }

    private static class StaticInnerSingletonHolder {
        public static StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getInstance() {
        return StaticInnerSingletonHolder.INSTANCE;
    }

    public Object readResolve() {
        return getInstance();
    }
}
