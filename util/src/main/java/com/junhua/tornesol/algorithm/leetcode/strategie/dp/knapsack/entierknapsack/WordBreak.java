package com.junhua.tornesol.algorithm.leetcode.strategie.dp.knapsack.entierknapsack;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    static public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            for (String word : wordDict) {
                if (i >= word.length()) {
                    int len = word.length();
                    String str = s.substring(i - len, i);
                    if (wordDict.contains(str))
                        dp[i] = dp[i] || dp[i - word.length()];
                }
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak("leetcode", wordDict));
    }


}
