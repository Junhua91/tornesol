package com.junhua.tornesol.algorithm.leetcode.strategie.twopoint;

public class SumOfSquareNumbers {

    static public boolean judgeSquareSum(int c) {

        int start = 1;
        int end = c / 2;

        while (start < end) {
            int num = start * start + end * end;
            if (num == c) return true;
            if (num > c) end--;
            else if (num < c) start++;
        }
        return false;
    }
}
