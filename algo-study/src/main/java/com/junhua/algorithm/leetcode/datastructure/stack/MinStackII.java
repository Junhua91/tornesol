package com.junhua.algorithm.leetcode.datastructure.stack;

import java.util.Stack;

public class MinStackII {


    Stack<Integer> stackData;
    Stack<Integer> stackMin;

    int min = Integer.MAX_VALUE;

    public MinStackII() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        min = Math.min(x, min);
        stackData.push(x);
        stackMin.push(min);

    }

    public void pop() {
        stackData.pop();
        stackMin.pop();
        min = stackMin.isEmpty() ? Integer.MAX_VALUE : stackMin.peek();
    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}
