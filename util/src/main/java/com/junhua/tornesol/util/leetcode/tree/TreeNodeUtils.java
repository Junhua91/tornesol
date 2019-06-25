package com.junhua.tornesol.util.leetcode.tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的增删改查，层级结构查询
 */
public class TreeNodeUtils {


    /**
     * 非递归方式中序排列
     *
     * @param root
     * @return
     */
    public static List<Integer> inOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1).setRight(new TreeNode(2).setLeft(new TreeNode(3)));
        List<Integer> result = inOrder(root);
        System.out.println();
    }

}
