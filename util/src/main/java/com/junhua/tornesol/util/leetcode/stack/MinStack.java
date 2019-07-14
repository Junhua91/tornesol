package com.junhua.tornesol.util.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    List<Integer> minList = new ArrayList<>();

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        addToList(x);

    }

    public void pop() {
        int num = stack.peek();
        if (num == minList.get(minList.size() - 1)) {
            minList.remove(minList.size() - 1);
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        int size = minList.size();
        return minList.get(size-1);
    }

    private void addToList(int num) {
        minList.add(num);

        for (int i = minList.size() - 1; i > 0; i--) {
            if (minList.get(i) > minList.get(i - 1)) {
                int temp = minList.get(i - 1);
                minList.set(i - 1, minList.get(i));
                minList.set(i, temp);
            }
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);


        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        minStack.top();
        System.out.println(minStack.getMin());
    }

}
