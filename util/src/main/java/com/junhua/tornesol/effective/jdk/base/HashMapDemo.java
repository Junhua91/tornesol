package com.junhua.tornesol.effective.jdk.base;

import java.util.HashMap;

public class HashMapDemo {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 保证容量永远是2^n: 3=>2^2, 5=>2^3...
     *
     * @param cap
     * @return
     */
    public static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(4, 0.75f);
        map.put(3, 3);
        map.put(7, 7);
        map.put(15, 15);
        new Thread(new MyThread(map, 22)).start();
        new Thread(new MyThread(map, 18)).start();
        System.out.println(map);
    }

    static class MyThread implements Runnable {
        private HashMap<Integer, Integer> map;
        private Integer key;

        public MyThread(HashMap<Integer, Integer> map, Integer key) {
            this.map = map;
            this.key = key;
        }

        @Override
        public void run() {
            map.put(key, key);
        }
    }

}
