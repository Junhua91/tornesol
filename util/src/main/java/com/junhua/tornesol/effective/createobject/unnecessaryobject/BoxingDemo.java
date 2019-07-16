package com.junhua.tornesol.effective.createobject.unnecessaryobject;

public class BoxingDemo {

    public static void main(String[] args) {

        test1();
        test2();
    }

    public static void test1() {
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) sum += i;
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void test2() {
        long start = System.currentTimeMillis();
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) sum += i;
        long end = System.currentTimeMillis();
        System.out.println(end-start);    }
}


