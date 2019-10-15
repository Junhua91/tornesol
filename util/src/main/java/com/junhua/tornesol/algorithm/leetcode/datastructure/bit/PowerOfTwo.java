package com.junhua.tornesol.algorithm.leetcode.datastructure.bit;

/**
 * leetCode 231
 */
public class PowerOfTwo {

    public static void main(String[] args) {

        System.out.println(isPowerOf2(4));
        System.out.println(isPowerOf2(5));
        System.out.println(isPowerOf2(8));
        System.out.println(isPowerOf2(17));

    }

    /**
     * 2=> 0010
     * 4=> 0100
     * 8=> 1000
     * ... 所有2的平方数，都只有一个1，于是去除一个1，看剩下的数是否为0
     *
     * @param n
     * @return
     */
    public static boolean isPowerOf2(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }

}
