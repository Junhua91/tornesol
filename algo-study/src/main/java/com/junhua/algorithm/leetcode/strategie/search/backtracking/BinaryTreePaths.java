package com.junhua.algorithm.leetcode.strategie.search.backtracking;

import com.junhua.algorithm.leetcode.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePaths {

    static public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<String> res = new ArrayList<>();
        find(root, "", res);
        return res;
    }

    static public void find(TreeNode root, String out, List<String> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(out + root.val);
            return;
        }
        find(root.left, out + root.val + "->", res);
        find(root.right, out + root.val + "->", res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1).setLeft(new TreeNode(2).setRight(new TreeNode(5)))
                .setRight(new TreeNode(3));

        TreeNode root2 = new TreeNode(1);
        List<String> res = binaryTreePaths(root);
        List<String> res2 = binaryTreePaths(root2);
        return;
    }
}
