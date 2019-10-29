package algorithm.leetcode.datastructure.string;

import java.util.ArrayList;
import java.util.List;

public class IsomorphicStrings {

    static public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        List l1 = find(s);
        List l2 = find(t);

        if (l1.size() != l2.size()) return false;

        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) != l2.get(i)) return false;
        }
        return true;
    }

    static public List find(String s) {
        List<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length - 1; ) {

            int j = i;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            list.add(j - i);
            i = j;
        }
        return list;
    }


    static public boolean isIsomorphic2(String s, String t) {

        int[] l1 = new int[255];
        int[] l2 = new int[255];


        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            if (l1[s1] != l2[t1]) return false;
            l1[s1] = i+1;
            l2[t1] = i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aa", t = "ab";

        System.out.println(isIsomorphic2(s, t));
    }
}
