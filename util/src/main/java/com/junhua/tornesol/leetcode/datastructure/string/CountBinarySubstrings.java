package com.junhua.tornesol.leetcode.datastructure.string;

public class CountBinarySubstrings {

    /**
     *
     * @param s
     * @return
     */
    static public int countBinarySubstrings(String s) {

        if (s == null || "".equals(s)) return 0;

        int[] group = new int[s.length()];
        int t = 0;
        group[0] = 1;
        //先分组
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                group[t]++;
            } else group[++t] = 1;
        }


        int res = 0;
        for (int i = 1; i < group.length; i++) {
            res += Math.min(group[i], group[i - 1]);
        }

        return res;

    }


    public static void main(String[] args) {
        String num = "00110011";

        int res = countBinarySubstrings(num);

        System.out.println(countBinarySubstrings("10101"));

        return;

    }
}
