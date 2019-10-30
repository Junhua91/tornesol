package com.junhua.algorithm.leetcode.strategie.divide;

public class FirstBadVersion {

    static public int firstBadVersion(int n) {

        int l = 0;
        int h = n;

        while (l < h) {
            int mid = (h - l) / 2 + l;
            if (isBadVersion(mid)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static boolean isBadVersion(int n) {
        return true;
    }
}
