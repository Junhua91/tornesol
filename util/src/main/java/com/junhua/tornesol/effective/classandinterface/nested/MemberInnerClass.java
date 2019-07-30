package com.junhua.tornesol.effective.classandinterface.nested;

public class MemberInnerClass {

    public int i = 0;
    public static int m = 1;

    public class PublicInnerClass {

        public void test() {
            System.out.println(i);
            System.out.println(m);
        }

        //static 不能在inner class中使用
//        public static void test2() {
//
//
//        }
    }
}
