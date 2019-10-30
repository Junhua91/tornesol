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
            sb.append('#');
            sb.append(c);
        }
        sb.append('#');
        int index = 0;
        int left = index - 1;
        int right = index + 1;
        int cnt = 1;
        int max = 0;
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
            max = Math.max(cnt, max);
            cnt = 1;
            left = index - 1;
            right = index + 1;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                int iLeft = max / 2;
                int sbIndex = 0;
                for (int j = i - iLeft; j < i + iLeft; j++) {
                    if (sb.charAt(j) != '#') {
                        sb.setCharAt(sbIndex++, sb.charAt(j));
                    }
                }
                break;
            }
        }
        return sb.substring(0, max / 2);
    }


    private static int lo, maxLen;

    public static String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    static private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    public static void main(String[] args) {
        String str = "bb";

        String res = longestPalindrome(str);

        return;
    }

}
