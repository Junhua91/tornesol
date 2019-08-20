package com.junhua.tornesol.leetcode.datastructure.bit;


/**
 * leetCode 338
 */
public class CountBits {

    public static void main(String[] args) {

        int[] count = createTestArray(4);

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i & (i - 1)] + 1;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }
    }

    static public int[] createTestArray(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            result[i] = i;
        }
        return result;
    }
}
