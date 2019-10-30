package com.junhua.algorithm.leetcode.strategie.twopoint;

import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {

    static public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String word : d) {
            if (res.length() > word.length() || (res.length() == word.length() && res.compareTo(word) < 0)) {
                continue;
            }
            if (find(s, word)) {
                res = word;
            }
        }
        return res;
    }

    static public boolean find(String s, String word) {
        int sStart = 0, wordStart = 0;
        while (wordStart < word.length() && sStart < s.length()) {
            if (s.charAt(sStart) == word.charAt(wordStart)) {
                sStart++;
                wordStart++;
            } else {
                sStart++;
            }
        }
        return wordStart == word.length();
    }


    public static void main(String[] args) {
        List<String> words = Arrays.asList("ale", "apple", "monkey", "plea");
        List<String> words3 = Arrays.asList("ba","ab","a","b");
        List<String> words2 = Arrays.asList("a", "b", "c", "d");
        String s = "abpcplea";

        System.out.println(findLongestWord(s, words));
        System.out.println(findLongestWord(s, words2));
        System.out.println(findLongestWord("bab", words3));
    }
}
