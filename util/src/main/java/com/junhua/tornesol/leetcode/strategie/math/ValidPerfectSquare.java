package com.junhua.tornesol.leetcode.strategie.math;


/**
 * #1. 平方数：1,4,9,16,27...
 * #2. 间隔: 3,5,7,9...
 */
public class ValidPerfectSquare {


    static public boolean isPerfectSquare(int num) {
        int ecart = 1;
        while (num > 0) {
            num -= ecart;
            ecart += 2;
        }
        return num == 0;
    }
}
