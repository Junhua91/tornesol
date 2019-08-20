package com.junhua.tornesol.leetcode.strategie.math;

public class FactorialTrailingZeroes {

    static public int trailingZeroes(int n) {
        if (n == 0) return 0;
        int res = 0;
        while (n != 0) {
            if (n % 5 == 0) {
                res++;
            }
            n = n / 5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(10));
        System.out.println(trailingZeroes(3));
        System.out.println(trailingZeroes(5));
    }
}
