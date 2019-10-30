package com.junhua.algorithm.leetcode.strategie.twopoint;

public class IsSubsequence {

    static public boolean isSubsequence(String s, String t) {

        if (s == null) return false;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int sp = 0, tp = 0;
        while (sp < ss.length && tp < tt.length) {
            if (ss[sp] == tt[tp]) {
                sp++;
                tp++;
            } else {
                tp++;
            }
        }
        return sp == s.length();
    }

    static public boolean isSubsequence2(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abdc", t = "ahbgdc";


        System.out.println(isSubsequence(s, t));
    }
}
