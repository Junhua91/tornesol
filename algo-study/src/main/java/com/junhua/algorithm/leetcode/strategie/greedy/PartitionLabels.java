package com.junhua.algorithm.leetcode.strategie.greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    static public List<Integer> partitionLabels(String S) {

        char[] cc = S.toCharArray();
        int[] charIndex = new int[26];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < cc.length; i++) {
            charIndex[cc[i] - 'a'] = i;
        }
        for (int i = 0; i < cc.length; ) {
            int lastIndex = charIndex[cc[i] - 'a'];
            for (int j = i + 1; j < lastIndex; j++) {
                int lastIndexJ = charIndex[cc[j]-'a'];
                if (lastIndexJ > lastIndex)
                    lastIndex = lastIndexJ;
            }
            res.add(lastIndex - i + 1);
            i = lastIndex + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacabefegdehijhklij";
        List<Integer> res = partitionLabels(s);
        return;
    }
}
