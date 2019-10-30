package com.junhua.algorithm.leetcode.strategie.dp;

public class LongestCommonSubsequence {

    /**
     * O(m*n)
     *
     * @param text1
     * @param text2
     * @return
     */
    static public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    static public int longestCommonSubsequence2(String text1, String text2) {
        return find(0, 0, text1, text2);
    }

    /**
     * O(n^2)
     *
     * @param i
     * @param j
     * @param t1
     * @param t2
     * @return
     */
    static public int find(int i, int j, String t1, String t2) {
        int m = t1.length(), n = t2.length();
        if (i == m || j == n) return 0;
        if (t1.charAt(i) == t2.charAt(j)) {
            return find(i + 1, j + 1, t1, t2) + 1;
        }
        return Math.max(find(i + 1, j, t1, t2), find(i, j + 1, t1, t2));
    }


    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence2("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence2("abc", "abc"));
        System.out.println(longestCommonSubsequence("abc", "def"));
        System.out.println(longestCommonSubsequence2("abc", "def"));

    }
}
