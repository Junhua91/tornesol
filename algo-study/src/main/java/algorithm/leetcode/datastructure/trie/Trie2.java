package algorithm.leetcode.datastructure.trie;

public class Trie2 {

    private TrieNode root;

    public Trie2() {
        root = new TrieNode(' ');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            } else node = node.children[c - 'a'];
        }
        node.isEndOfWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return node.isEndOfWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {

        if (prefix == null) return false;
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return true;
    }

    class TrieNode {
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
}
