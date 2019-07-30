package com.junhua.tornesol.effective.string;

public class InternDemo {

    public static void main(String[] args) {
        intern();
    }

    /**
     * intern:如果常量不存在常量池里，则在常量池里创建一个常量，并返回常量次里的引用
     */
    public static void intern() {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}
