package com.junhua.algorithm.leetcode.datastructure.bit;


/**
 * is the number of positions at which the corresponding bits are different.
 */
public class HammingDistance {

    static public int hammingDistance(int x, int y) {
        int num = x ^ y;
        return Integer.bitCount(num);
    }


    static public int hammingDistance2(int x, int y) {
        int num = x ^ y;
        int count = 0;

        while (num != 0) {
            if ((num & 1) == 1) count++;
            num = num >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
        System.out.println(hammingDistance2(1, 4));
    }
}
