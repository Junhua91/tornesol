package com.junhua.tornesol.effective.jdk.base;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {

    }


    /**
     * 多线程下，读写分离
     * 1. 将原array复制一份,创建一个新的数组：Object[] newElements = Arrays.copyOf(elements, len + 1);
     * 2. 将更改过后的新数组再次重新赋值给原先的数组：setArray(newElements);
     */
    public static void add() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
    }
}
