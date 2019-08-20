package com.junhua.tornesol.leetcode.strategie.search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    static public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        find(s, res, 4, "");
        return res;
    }


    public static void find(String s, List<String> res, int k, String out) {
        if (k == 0) {
            if (s.isEmpty()) res.add(out);
            return;
        } else {
            for (int i = 1; i <= 3; i++) {
                if (s.length() >= i && isValid(s.substring(0, i))) {
                    if (k == 1) find(s.substring(i), res, k - 1, out + s.substring(0, i));
                    else find(s.substring(i), res, k - 1, out + s.substring(0, i) + ".");
                }
            }
        }
    }

    public static boolean isValid(String s) {
        if (s.isEmpty() || s.length() > 3 || (s.length() > 1 && s.charAt(0) == '0')) return false;
        int res = Integer.valueOf(s);
        return res <= 255 && res >= 0;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res = restoreIpAddresses(s);

        return;
    }
}
