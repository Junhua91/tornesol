package com.junhua.tornesol.leetcode.strategie.search.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return Collections.emptyList();
        List<String> res = new ArrayList<>();
        find(digits, res, "", 0);
        return res;
    }

    public static void find(String digits, List<String> res, String out, int level) {
        if (level == digits.length()) {
            res.add(out);
            return;
        }
        String keys = KEYS[digits.charAt(level) - '0'];
        for (int i = 0; i < keys.length(); i++) {
            find(digits, res, out + keys.charAt(i), level + 1);
        }
    }

    public static void main(String[] args) {
        List<String> res = letterCombinations("23");
        return;
    }
}
