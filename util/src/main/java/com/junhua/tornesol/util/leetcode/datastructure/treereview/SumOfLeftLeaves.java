package com.junhua.tornesol.util.leetcode.datastructure.treereview;

import com.junhua.tornesol.util.leetcode.datastructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {

    static public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int result = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) result += root.left.val;
            else result += sumOfLeftLeaves(root.left);
        }
        result += sumOfLeftLeaves(root.right);
        return result;
    }

    static public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    if (node.left.left == null && node.left.right == null) res += node.left.val;
                    else queue.offer(node.left);
                }
                if (node.right != null) queue.offer(node.right);
            }
        }

        return res;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3).setLeft(new TreeNode(9))
                .setRight(new TreeNode(20).setLeft(new TreeNode(15)).setRight(new TreeNode(7)));
        System.out.println(sumOfLeftLeaves(root));
        System.out.println(sumOfLeftLeaves2(root));
    }


}
