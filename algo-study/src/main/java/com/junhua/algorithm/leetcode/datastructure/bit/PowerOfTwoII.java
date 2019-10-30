package com.junhua.algorithm.leetcode.datastructure.bit;

public class PowerOfTwoII {

    static public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

    static public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
