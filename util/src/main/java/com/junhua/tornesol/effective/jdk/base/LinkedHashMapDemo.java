package com.junhua.tornesol.effective.jdk.base;


import java.util.LinkedHashMap;

/**
 * 内部维护了一个双向链表，用来维护顺序
 * 1. 插入顺序(accessOrder = false默认)
 * 2. LRU 顺序（accessOrder = true）
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(8, 0.75f, true);

        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");

        map.get(2);
        map.keySet().forEach(System.out::println);

    }
}
