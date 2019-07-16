package com.junhua.tornesol.effective.createobject.unnecessaryobject;

/**
 * use String s = "hello" instead of String s = new String("hello)
 */
public class StringDemo {


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String s = "hell0";
            System.out.println(s.hashCode());
            String s2 = new String("hell0");
            System.out.println(s2.getClass());
        }
    }
}

