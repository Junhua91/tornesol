package com.junhua.tornesol.effective.classandinterface.nested;

/**
 * nested class 分为以下几类
 * 1. static member nested class
 * 2. member nested class（inner class，不准包含static）
 * 3. local nested class
 * 4. anonymous nested class
 */
public class EnclosingClass {

    public static class StaticNestedMemberClass {

    }

    public class NestedMemberClass {

    }

    /**
     * 3. 定义在enclosing 类的方法里
     */
    public void nestedLocalClass() {

        final class NestedLocalClass {

        }
    }

    /**
     * 4. 没有显示创建一个类，通过new创建
     */
    public void nestedAnonymousClass() {

        new Runnable() {

            @Override
            public void run() {
            }
        };
    }
}
