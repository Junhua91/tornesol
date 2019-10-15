package com.junhua.tornesol.algorithm.leetcode.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {


    static int min = Integer.MAX_VALUE;

    static public int minDepth(TreeNode root) {

        if (root == null) return 0;

        int left = minDepth(root.left);

        int right = minDepth(root.right);

        return (left == 0 || right == 0) ? right + left + 1 : Math.min(left, right) + 1;

    }

    static public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return level;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            level++;
        }
        return level;
    }


    static public int DFS(TreeNode root) {

        if (root == null) return 0;

        int right = DFS(root.right);
        int left = DFS(root.left);

        return (left == 0 || right == 0) ? (left + right + 1) :
                Math.min(left, right) + 1;

    }

    static public int BFS(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int level = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return level;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return level;

    }

    static public void main(String[] agrs) {

        TreeNode root = new TreeNode(3).setLeft(new TreeNode(9))
                .setRight(new TreeNode(20).setLeft(new TreeNode(15)).setRight(new TreeNode(7)));


        TreeNode root2 = new TreeNode(1).setRight(new TreeNode(2));

        System.out.println(minDepth(root));
        System.out.println(DFS(root));
        System.out.println(BFS(root));
        System.out.println(minDepth2(root));
        System.out.println(minDepth(root2));
        System.out.println(minDepth2(root2));
        System.out.println(DFS(root2));
        System.out.println(BFS(root2));
    }
}
