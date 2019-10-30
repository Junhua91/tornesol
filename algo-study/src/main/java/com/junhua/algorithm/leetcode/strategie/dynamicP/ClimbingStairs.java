package com.junhua.algorithm.leetcode.strategie.dynamicP;

public class ClimbingStairs {

    public static void main(String[] args) {

        System.out.println(f(3));
        System.out.println(f(4));
        System.out.println(f(5));
        System.out.println(f2(14));
        System.out.println(f2(15));
        System.out.println(f2(16));


    }

    public static int f(int n) {
        return (n == 1 || n == 0) ? 1 : f(n - 1) + f(n - 2);
    }

    public static int f2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i < n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n - 1];
    }

    public static int f3(int n) {

        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 1;


        for (int i = 2; i < n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n - 1];
    }
}
