package com.junhua.algorithm.leetcode.datastructure.string;

public class LongestPalindromicSubstring {


    /**
     * 时间复杂度O(N^2)
     *
     * @param s
     * @return
     */
    static public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) return s;

        //添加分隔符
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            sb.append(1);
            sb.append(c);
        }
        sb.append(1);

        int index = 0;
        int left = index - 1;
        int right = index + 1;
        int cnt = 1;

        int[] count = new int[sb.length()];

        while (index < sb.length()) {

            while (left >= 0 && right < sb.length()) {
                if (sb.charAt(left) == sb.charAt(right)) {
                    left--;
                    right++;
                    cnt += 2;
                } else {
                    break;
                }
            }
            count[index++] = cnt;
            cnt = 1;
            left = index - 1;
            right = index + 1;
        }

        return "";
    }


    public static void main(String[] args) {
        String str = "babad";

        longestPalindrome(str);
    }

}
