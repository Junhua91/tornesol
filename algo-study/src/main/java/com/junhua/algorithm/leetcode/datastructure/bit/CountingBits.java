package com.junhua.algorithm.leetcode.datastructure.bit;

public class CountingBits {

    static public int[] countBits(int num) {

        int[] res = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }


    static public int[] countBits2(int num) {

        int[] res = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = countBits(5);
        return;
    }
}
