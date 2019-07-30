package com.junhua.tornesol.util.leetcode.strategie.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 桶排序
 */
public class SortCharactersByFrequency {

    static public String frequencySort(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        for (Character c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        ArrayList<Character>[] bucket = new ArrayList[s.length() + 1];
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            if (bucket[count] == null) {
                bucket[count] = new ArrayList();
            }
            for (int i = 0; i < count; i++) {
                bucket[count].add(c);
            }
        }
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null) continue;
            for (char c : bucket[i]) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("Aabb"));

    }
}
