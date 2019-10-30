package com.junhua.algorithm.leetcode.strategie.math;

public class ExcelSheetColumnTitle {


    static public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            if (n % 26 == 0) {
                sb.append('Z');
                n = n - 26;
            } else sb.append((char) (n % 26 + 64));
            n = n / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(701));

    }
}
