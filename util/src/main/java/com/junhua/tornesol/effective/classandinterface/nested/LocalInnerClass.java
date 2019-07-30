package com.junhua.tornesol.effective.classandinterface.nested;


public class LocalInnerClass {

    private int i = 0;
    public static int j = 1;
    private final int m = 2;

    static public void test() {
        final int a = 11;
        int b = 22;

        /**
         * 只能使用enclosing class的static 变量
         *
         */
        class LocalStaticInnerClass {

            public LocalStaticInnerClass() {
                System.out.println(j);
                System.out.println(a);
                System.out.println(b);
            }
        }

        new LocalStaticInnerClass();
    }

    public void test2() {
        final int a = 11;
        int b = 22;

        /**
         * 可以使用enclosing类的非static 成员变量
         */
        class LocalStaticInnerClass {

            public LocalStaticInnerClass() {
                System.out.println(j);
                System.out.println(a);
                System.out.println(b);
                System.out.println(i);
            }
        }

        new LocalStaticInnerClass();

    }
}
