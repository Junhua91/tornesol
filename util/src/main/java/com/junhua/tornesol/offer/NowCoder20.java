package com.junhua.tornesol.offer;


import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class NowCoder20 {

    static Stack<Integer> stack = new Stack<>();

    static public boolean IsPopOrder(int[] pushA, int[] popA) {
        int len = popA.length;
        for (int i = 0, j = 0; i < len; i++) {
            stack.push(pushA[i]);
            while (j < len && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public boolean IsPopOrder2(int[] pushA, int[] popA) {
        int len = popA.length;
        int i = 0, j = 0;
        for (; i < len && j < len; ) {
            if (popA[j] != pushA[i]) {
                stack.push(pushA[i]);
                i++;
                continue;
            } else if (pushA[i] == popA[j]) {
                i++;
                j++;
            }
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != popA[j]) return false;
            else j++;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};

        System.out.println(IsPopOrder(pushA, popA));
    }
}
