package com.junhua.tornesol.util.leetcode.bit;

public class BinaryNumberWithAlternatingBits {

    static public boolean hasAlternatingBits(int n) {
        int res = n ^ (n >> 1);
        return (res & (res + 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
    }
}
