package com.junhua.tornesol.util.leetcode.datastructure.hash;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        int[] sCount = count(s);
        int[] tCount = count(t);
        for (int i = 0; i < 26; i++) {
            if (sCount[i] != tCount[i]) {
                return false;
            }
        }
        return sCount == tCount;
    }

    public static int[] count(String s) {
        int[] counts = new int[26];
        for (Character c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        return counts;
    }

    public static boolean isAnagram2(String s, String t) {
        int[] sCount = count(s);
        for (Character c : t.toCharArray()) {
            sCount[c - 'a']--;
        }

        for (int i : sCount) {
            if (i != 0) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";


        System.out.println(isAnagram(s, t));
    }
}
