package com.junhua.tornesol.effective.classandinterface.nested;

public class StaticNestedTest {


    public static void main(String[] args) {
        StaticNestedClassDemo.PublicNestedClass t = new StaticNestedClassDemo.PublicNestedClass();
//        StaticNestedClassDemo.PrivateNestedClass t2 = new StaticNestedClassDemo.PrivateNestedClass();
        t.test1();
        StaticNestedClassDemo.PublicNestedClass.test();
//        t2.test1();
    }
}
