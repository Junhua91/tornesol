package com.junhua.tornesol.effective.classandinterface.nested;

public class InnerClassTest {

    public static void main(String[] args) {


    }

    /**
     * Inner class
     */
    public static void test() {
        MemberInnerClass memberInnerClass = new MemberInnerClass();
        MemberInnerClass.PublicInnerClass publicInnerClass = memberInnerClass.new PublicInnerClass();
        publicInnerClass.test();
    }

    /**
     * local static Inner class
     */
    public static void test2() {
        //方法是static
        LocalInnerClass.test();
    }
}
