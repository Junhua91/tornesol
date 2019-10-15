package com.junhua.tornesol.algorithm.leetcode.datastructure.string;

public class PalindromicSubstrings {

    public static int count = 0;

    static public int countSubstrings(String s) {

        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) {
            find(s, i, i);
            find(s, i, i + 1);
        }

        return count;

    }

    public static void find(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            end++;
            start--;
            count++;
        }
    }

    public static void main(String[] args) {
        String s = "aaa";

        System.out.println(countSubstrings(s));

    }
}
