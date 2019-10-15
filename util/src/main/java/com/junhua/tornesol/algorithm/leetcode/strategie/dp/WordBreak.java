package com.junhua.tornesol.algorithm.leetcode.strategie.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    static public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String>set =new HashSet<>(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i <= len; i++) {
            for (String word : wordDict) {
                if (i >= word.length()) {
                    String s1 = s.substring(i - word.length(), i);
                    if (set.contains(s1)) {
                        dp[i] = dp[i - word.length()] || dp[i];
                    }
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        List<String> dicts = Arrays.asList("apple", "pen");
        System.out.println(wordBreak("applepenapple", dicts));
    }
}
