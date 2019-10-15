package com.junhua.tornesol.algorithm.offer;


import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
 * （时间复杂度应为O（1））
 */
public class NowCoder19 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    int min = Integer.MAX_VALUE;

    public void push(int node) {
        min = Math.min(node, min);
        stack.push(node);
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.isEmpty()?Integer.MAX_VALUE:minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
