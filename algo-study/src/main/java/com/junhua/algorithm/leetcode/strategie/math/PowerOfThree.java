package com.junhua.algorithm.leetcode.strategie.math;

/**
 * #1. 1, 3, 9, 27 ,81
 * #2.  2, 6, 18, 54
 */
public class PowerOfThree {


    static public boolean isPowerOfThree(int n) {

        int ecart = 2;

        while (n > 1) {
            n -= ecart;
            ecart *= 3;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(3));
        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(45));
    }
}
