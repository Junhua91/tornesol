package com.junhua.tornesol.leetcode.strategie.divide;

import com.junhua.tornesol.leetcode.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {


    static public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = find(1, n);
        return list;
    }

    static List<TreeNode> find(int s, int e) {
        List<TreeNode> res = new ArrayList<>();
        if (e < s) {
            res.add(null);
            return res;
        }
        for (int i = s; i <= e; i++) {
            List<TreeNode> left = find(s, i - 1);
            List<TreeNode> right = find(i + 1, e);
            for (TreeNode nodeLeft : left) {
                for (TreeNode nodeRight : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = nodeLeft;
                    root.right = nodeRight;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        generateTrees(3);
    }
}
