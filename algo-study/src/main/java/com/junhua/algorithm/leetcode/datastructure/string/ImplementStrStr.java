package com.junhua.algorithm.leetcode.datastructure.string;

public class ImplementStrStr {


    /**
     * 时间复杂度O（M*N）
     *
     * @param haystack
     * @param needle
     * @return
     */
    static public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) return 0;
        int lIndex = 0;

        int lLength = haystack.length();
        int rLength = needle.length();

        for (; lIndex < lLength; lIndex++) {
            int index = lIndex;
            int rIndex = 0;
            while (rIndex < rLength && index < lLength) {
                if (haystack.charAt(index) == needle.charAt(rIndex)) {
                    rIndex++;
                    index++;
                } else {
                    break;
                }
                if (rIndex == rLength) return lIndex;
            }
        }
        return -1;
    }


    /**
     * KMP算法： O(M+N)
     *
     * @param haystack
     * @param needle
     * @return
     */
    static public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {

        String hayStack = "hello";
        String hayStack2 = "aaaaa";
        String hayStack3 = "mississippi";
        String hayStack4 = "mississippi";
        String hayStack5 = "aaa";


        String needle = "ll";
        String needle2 = "aab";
        String needle3 = "issipi";
        String needle4 = "issip";
        String needle5 = "aaaa";


        int n = strStr2(hayStack, needle);
        int n2 = strStr2(hayStack2, needle2);
        int n3 = strStr2(hayStack3, needle3);
        int n4 = strStr2(hayStack4, needle4);
        int n5 = strStr2(hayStack5, needle5);
        return;
    }
}

