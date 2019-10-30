package com.junhua.algorithm.leetcode.datastructure.treereview;


import com.junhua.algorithm.leetcode.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {


    static public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

    static public List<Integer> preorderTraversal2(TreeNode root) {

        if (root == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            stack.push(node.right);
            stack.push(node.left);
            res.add(node.val);
        }
        return res;
    }
}
