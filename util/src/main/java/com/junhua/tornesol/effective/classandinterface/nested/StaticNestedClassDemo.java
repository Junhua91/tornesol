package com.junhua.tornesol.effective.classandinterface.nested;

/**
 * 1. 创建方式：new EnclosingClass.PublicNestedClass()
 * 2.
 */
public class StaticNestedClassDemo {

    private int i = 0;
    private static int m = 1;

    public static class PublicNestedClass {
        public void test1() {
            System.out.println(m);
        }

        public static void test() {
            System.out.println("test static");
        }
    }

    private static class PrivateNestedClass {

        public void test1() {
            System.out.println(m);
        }
    }
}
