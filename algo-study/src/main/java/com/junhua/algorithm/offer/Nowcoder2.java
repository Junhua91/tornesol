package com.junhua.algorithm.offer;


/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Nowcoder2 {

    static public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        return s.replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(sb));
    }
}
