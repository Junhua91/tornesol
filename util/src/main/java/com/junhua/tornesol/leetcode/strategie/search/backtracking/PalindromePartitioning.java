package com.junhua.tornesol.leetcode.strategie.search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    static public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> out = new ArrayList<>();
        find(s, res, out);
        return res;
    }


    static public void find(String s, List<List<String>> res, List<String> out) {

        if (s.length() == 0) {
            res.add(new ArrayList<>(out));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                out.add(s.substring(0, i + 1));
                find(s.substring(i + 1), res, out);
                out.remove(out.size() - 1);
            }
        }
    }

    static public boolean isPalindrome(String s, int start, int end) {
        char[] chs = s.toCharArray();
        if (chs.length == 1) return true;
        while (start < end) {
            if (chs[start] != chs[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = partition("aab");
        return;

    }
}
