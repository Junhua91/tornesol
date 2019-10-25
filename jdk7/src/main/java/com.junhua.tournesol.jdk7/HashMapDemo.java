package com.junhua.tournesol.jdk7;

import java.util.HashMap;

public class HashMapDemo {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<Integer, String>(2, 0.75f);
        map.put(5, "C");
        map.put(3, "A");
        map.put(7, "B");

//        new Thread("Thread1") {
//            public void run() {
//                map.put(7, "B");
//                System.out.println(map);
//            }
//        }.start();
//
//        new Thread("Thread2") {
//            public void run() {
//                map.put(3, "A");
//                System.out.println(map);
//            }
//        }.start();
    }

}
