package com.junhua.tornesol.util.leetcode.datastructure.bit;

public class MaximumProductOfWordLengths {


    static public int maxProduct(String[] words) {
        int[] res = new int[words.length];
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                res[i] |= (1 << (c - 'a'));
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((res[i] & res[j]) == 0) {
                    count = Math.max(count, words[i].length() * words[j].length());
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};

        System.out.println(maxProduct(words));
    }
}
