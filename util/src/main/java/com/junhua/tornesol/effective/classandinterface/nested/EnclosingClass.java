package com.junhua.tornesol.effective.classandinterface.nested;

/**
 * nested class 分为以下几类
 * 1. member nested class： 定义在enclosing class 类中，拥有类的属性； （public,private, protected, static, final）
 * 2. local nested class: 定义在enclosing class的方法中，拥有enclosing class、method属性; final
 * 2. anonymous nested class
 *
 * 另外一种分类
 * 1. static nested class: 用static修饰
 * 2. inner class: 不能用static修饰
 *      - inner member class: 没有用static 修饰的成员内部类
 *      - local inner classes：定义在方法里
 *      - anonymous inner classes
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
