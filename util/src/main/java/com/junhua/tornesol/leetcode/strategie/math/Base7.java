package com.junhua.tornesol.leetcode.strategie.math;

public class Base7 {


    static public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        int validNum = (num >= 0) ? num : -num;
        while (validNum > 0) {
            sb.append(validNum % 7);
            validNum = validNum / 7;
        }
        sb.reverse();
        return num >= 0 ? sb.toString() : "-" + sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(-7));
    }
}
