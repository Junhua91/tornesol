package com.junhua.tornesol.util.leetcode.tree;

import java.util.List;

/**
 * 多维Tree
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}