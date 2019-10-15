package com.junhua.tornesol.algorithm.leetcode.datastructure.treereview;

import com.junhua.tornesol.algorithm.leetcode.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    static public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            stack.push(node.left);
            stack.push(node.right);
            res.add(node.val);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1).setRight(new TreeNode(2).setLeft(new TreeNode(3)));

        List<Integer> res = postorderTraversal(root);
        return;
    }

}
