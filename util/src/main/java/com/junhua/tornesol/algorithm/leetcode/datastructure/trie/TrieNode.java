package com.junhua.tornesol.algorithm.leetcode.datastructure.trie;

public class TrieNode {

    /**
     * 这里的size 按照支持的字符来定
     */
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
    char val;

    public TrieNode(char val) {
        isEndOfWord = false;
        this.val = val;
        for (int i = 0; i < children.length; i++) {
            children[i] = null;
        }
    }
}
