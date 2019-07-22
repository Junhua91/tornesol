package com.junhua.tornesol.util.leetcode.treereview;

import com.junhua.tornesol.util.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

    static public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null && node.left == null && node.right == null) return res;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res++;
        }
        return res;
    }


    static public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }


    static public void main(String[] agrs) {

//        TreeNode root = new TreeNode(3).setLeft(new TreeNode(9))
//                .setRight(new TreeNode(20).setLeft(new TreeNode(15)).setRight(new TreeNode(7)));
        TreeNode root2 = new TreeNode(1).setRight(new TreeNode(2));
//        System.out.println(minDepth(root));
        System.out.println(minDepth(root2));
    }

}
