package com.junhua.algorithm.leetcode.datastructure.tree;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();


    /**
     * 先把最左node 推到stack
     *
     * @param root
     */
    public BSTIterator(TreeNode root) {
        TreeNode currentNode = root;
        while (currentNode != null) {
            stack.push(currentNode);
            if (currentNode.left != null) {
                currentNode = currentNode.left;
            } else break;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            TreeNode curNode = node.right;
            while (curNode != null) {
                stack.push(curNode);
                if (curNode.left != null) {
                    curNode = curNode.left;
                } else break;
            }
        }
        return node.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
