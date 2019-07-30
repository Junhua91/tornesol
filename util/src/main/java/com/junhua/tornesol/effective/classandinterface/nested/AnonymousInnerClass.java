package com.junhua.tornesol.effective.classandinterface.nested;


/**
 * 直接new 一个实例，通过默认实现一个接口创建一个匿名类
 */
public class AnonymousInnerClass {


    public void test() {

        //匿名类实现
        new Thread(new Runnable() {

            @Override
            public void run() {

            }
        }).start();

    }
}
