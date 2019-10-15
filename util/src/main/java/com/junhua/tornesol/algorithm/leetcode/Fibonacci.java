package com.junhua.tornesol.algorithm.leetcode;

public class Fibonacci {


    /**
     * 递归法：O(2^n)
     *
     * @param n
     * @return
     */
    public static int f1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return f1(n - 1) + f1(n - 2);
    }


    /**
     * 递推法：O(N)
     *
     * @param n
     * @return
     */
    public static int f2(int n) {

        int[] nums = new int[n+1];

        nums[0] = 0;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }

        return nums[n ];
    }

    public static void main(String[] args) {

        System.out.println(f1(5));
        System.out.println(f2(5));
    }
}
