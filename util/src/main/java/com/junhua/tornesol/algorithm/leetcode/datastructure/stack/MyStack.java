package com.junhua.tornesol.algorithm.leetcode.datastructure.stack;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> linkedList;

    /**
     * Initialize your com.junhua.mybatis.data structure here.
     */
    public MyStack() {
        linkedList = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        linkedList.add(x);
        int size = linkedList.size();
        while (size > 1) {
            linkedList.add(linkedList.remove());
            size--;
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return linkedList.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return linkedList.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return linkedList.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack() ;


        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}