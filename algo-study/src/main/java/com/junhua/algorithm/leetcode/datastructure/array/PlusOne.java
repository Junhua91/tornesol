package com.junhua.algorithm.leetcode.datastructure.array;

public class PlusOne {

    static public int[] plusOne(int[] digits) {

        int addition = 1;

        int index = digits.length - 1;

        while (addition == 1 && index >= 0) {
            int sum = addition + digits[index];
            if (sum == 10) {
                digits[index--] = 0;
            } else {
                digits[index] = sum;
                addition = 0;
            }
        }

        if (addition == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = addition;
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] nums = {8, 9, 9, 9};
        int[] res = plusOne(nums);
        return;

    }

}
