package com.junhua.tornesol.util.leetcode.bit;

public class NumberComplement {

    /**
     * 找到第一个1的位置
     *
     * @param num
     * @return
     */
    static public int findComplement(int num) {
        int mask = 1 << 31;
        while ((mask & num) == 0) {
            mask >>>= 1;
        }
        return ((mask << 1) - 1) ^ num;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
    }
}
