package com.junhua.tornesol.algorithm.leetcode.datastructure.treereview;

import com.junhua.tornesol.algorithm.leetcode.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    static public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1).setRight(new TreeNode(2).setLeft(new TreeNode(3)));

        List<Integer> res = inorderTraversal(root);
        return;
    }
}
