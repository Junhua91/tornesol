package com.junhua.tornesol.util.leetcode.datastructure.bit;

public class SumOfTwoIntegers {

    static public int getSum(int a, int b) {

        int c;
        while (b != 0) {
            c = a & b;
            a = a ^ b;
            b = (c << 1);
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
        System.out.println(getSum(-2, 3));
    }
}
