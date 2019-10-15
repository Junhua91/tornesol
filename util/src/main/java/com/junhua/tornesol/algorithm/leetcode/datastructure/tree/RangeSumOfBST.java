package com.junhua.tornesol.algorithm.leetcode.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumOfBST {

    static int sum = 0;

    static public int rangeSumBST(TreeNode root, int L, int R) {
        int sum1 = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.getVal() >= L && node.getVal() <= R) sum1 += node.getVal();
                if (node.getLeft() != null) queue.offer(node.getLeft());
                if (node.getRight() != null) queue.offer(node.getRight());
            }
        }
        return sum1;
    }

    static public int rangeSumBST2(TreeNode root, int L, int R) {

        if (root == null) return 0;

        if (root.getVal() > R) rangeSumBST2(root.getLeft(), L, R);
        if (root.getVal() < L) rangeSumBST2(root.getRight(), L, R);

        return root.getVal() + rangeSumBST2(root.getRight(), L, R) + rangeSumBST2(root.getLeft(), L, R);

    }


    static void f(TreeNode root, int L, int R) {
        if (root == null) return;
        f(root.getLeft(), L, R);
        if (root.getVal() >= L && root.getVal() <= R) sum += root.getVal();
        f(root.getRight(), L, R);
    }

    static public void main(String[] args) {
        TreeNode root = new TreeNode(10).setLeft(new TreeNode(5).setLeft(new TreeNode(3)).setRight(new TreeNode(7)))
                .setRight(new TreeNode(15).setRight(new TreeNode(18)));

        //System.out.println(rangeSumBST(root, 7, 15));
        System.out.println(rangeSumBST2(root, 7, 15));

    }
}
