package com.junhua.tornesol.util.leetcode.datastructure.stack;

import java.util.Stack;

public class DailyTemperatures {


    static public int[] dailyTemperatures(int[] T) {

        if (T == null || T.length == 0) return null;

        int[] res = new int[T.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return res;

    }

    static public int[] dailyTemperatures2(int[] T) {
        if (T == null || T.length == 0) return null;
        int[] res = new int[T.length];
        int[] stack = new int[T.length];
        int top = -1;

        for (int i = 0; i < T.length; i++) {
            while (top >=0 && T[i] > T[stack[top]]) {
                res[stack[top]] = i - stack[top];
                top--;
            }
            stack[++top] = i;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] res = dailyTemperatures(nums);
        int[] res2 = dailyTemperatures2(nums);
        return;

    }
}
