package com.junhua.tornesol.effective.classandinterface.nested;


/**
 * nested 层级关系
 * #1. member class: A$B(A:enclosing class; B:member class)
 * #2. inner class: A$1B(A:enclosing class; B:first inner local class)
 * #3. anonymous inner class: A$N(N:匿名类的个数)
 */
public class NestedLevel {

    //NestedLevel$A
    class A {

        private int i = 1;

        //NestedLevel$A$B
        public class B {

        }

    }

    public void test() {
        //NestedLevel$1B
        class B {
            //NestedLevel$1B$A
            class A {
            }
        }
    }


    public void test2() {

        //NestedLevel$1
        new Runnable() {
            @Override
            public void run() {
            }
        };

        //NestedLevel$1
        new Runnable() {
            @Override
            public void run() {
            }
        };
    }

    public static class E{

    }


}
