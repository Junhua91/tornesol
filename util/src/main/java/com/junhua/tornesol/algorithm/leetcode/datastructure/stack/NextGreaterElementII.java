package com.junhua.tornesol.algorithm.leetcode.datastructure.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {


    static public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int length = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[length];
        Arrays.fill(res, -1);
        for (int i = 0; i < length * 2; i++) {
            int num = nums[i % length];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                res[stack.pop()] = num;
            }
            if (i < length)
                stack.push(i);
        }
        return res;
    }

    static public int[] nextGreaterElements2(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int length = nums.length;

        int top = -1;
        int[] res = new int[length];
        Arrays.fill(res, -1);
        int[] stack = new int[length];


        for (int i = 0; i < length * 2; i++) {
            int num = nums[i % length];
            while (top >-1 && nums[stack[top]] < nums[i % length]) {
                res[stack[top]] = num;
                top--;
            }

            if (i < length ) {
                stack[++top] = i;
            }
        }


        return res;


    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        int[] res = nextGreaterElements(nums);
        int[] res2 = nextGreaterElements2(nums);
        return;
    }
}
