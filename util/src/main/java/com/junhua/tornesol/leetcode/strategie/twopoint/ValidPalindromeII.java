package com.junhua.tornesol.leetcode.strategie.twopoint;

public class ValidPalindromeII {

    static public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        for (int i = 0; i <= end; i++) {
            if (s.charAt(start) != s.charAt(end)) {
                return find(s.toCharArray(), start + 1, end) || find(s.toCharArray(), start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean find(char[] chars, int start, int end) {
        while (start < end) {
            if (chars[start++] != chars[end--]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(validPalindrome(s));
    }
}
