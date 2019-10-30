package com.junhua.algorithm.leetcode.strategie.search.bfs;

import java.util.*;

public class WordLadder {


    /**
     * 1. HashSet的查询效率要高于List
     * 2. 将符合条件的对象放入queue中（BFS：只遍历符合条件的）
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    static public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        HashSet<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Map<String, Integer> countMap = new HashMap<String, Integer>() {{
            put(beginWord, 1);
        }};
        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            for (int i = 0; i < currentWord.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ++ch) {
                    char[] chs = currentWord.toCharArray();
                    chs[i] = ch;
                    String newWord = new String(chs);
                    if (endWord.equals(newWord)) {
                        return countMap.get(currentWord) + 1;
                    }
                    if (wordSet.contains(newWord) && !countMap.containsKey(newWord)) {
                        int oldCount = countMap.get(currentWord);
                        int newCount = oldCount + 1;
                        countMap.put(newWord, newCount);
                        queue.offer(newWord);
                    }
                }
            }
        }
        return 0;
    }


    static public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        HashSet<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) return res;

                for (int j = 0; j < currentWord.length(); j++) {

                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] chs = currentWord.toCharArray();
                        chs[j] = c;
                        String newWord = new String(chs);

                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength("hit", "cog", wordList));
        System.out.println(ladderLength2("hit", "cog", wordList));
    }
}
