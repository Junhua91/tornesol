package com.junhua.tornesol.leetcode.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxMInDepth {


    public static TreeNode TEST_TREE_NODE = new TreeNode(3).setLeft(new TreeNode(9))
            .setRight(new TreeNode(20).setLeft(new TreeNode(15).setRight(new TreeNode(4)))
                    .setRight(new TreeNode(7)));

    public static int MAX_LEVEL = Integer.MIN_VALUE;
    public static int MIN_LEVEL = Integer.MAX_VALUE;


    /**
     * DFS的模版:
     * public static void DFS(TreeNode root, int level) {
     * if (root == null) {
     * return;
     * }
     * //do something
     * DFS(root.getLeft(), level + 1);
     * DFS(root.getRight(), level + 1);
     * }
     *
     * @param root
     * @param level
     */
    public static void DFS(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            if (MIN_LEVEL > level) {
                MIN_LEVEL = level;
            }
            if (MAX_LEVEL < level) {
                MAX_LEVEL = level;
            }
        }
        DFS(root.getLeft(), level + 1);
        DFS(root.getRight(), level + 1);
    }

    /**
     * BFS 模版：
     * Queue<TreeNode> queue = new LinkedList<>();
     * queue.offer(root);
     * while (!queue.isEmpty()) {
     * int size = queue.size();
     * for (int i = 0; i < size; i++) {
     * TreeNode node = queue.poll();
     * //to do something
     * if (node.getLeft() != null) {
     * queue.offer(node.getLeft());
     * }
     * if (node.getRight() != null) {
     * queue.offer(node.getRight());
     * }
     * }
     * }
     *
     * @param root
     * @return
     */

    public static int[] BFS(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isLeaf(node)) {
                    if (level < min) {
                        min = level;
                    }
                    if (level > max) {
                        max = level;
                    }
                }
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }

            }
            level++;
        }
        return new int[]{max, min};
    }

    public static boolean isLeaf(TreeNode root) {
        return root != null && (root.getLeft() == null) && (root.getRight() == null);
    }

    public static void main(String[] args) {

        DFS(TEST_TREE_NODE, 0);
        System.out.println(MAX_LEVEL);
        System.out.println(MIN_LEVEL);

        int[] result = BFS(TEST_TREE_NODE);

        for (int num : result) {
            System.out.println(num);
        }
    }

}
