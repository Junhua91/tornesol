package com.junhua.tornesol.leetcode.datastructure.treereview.BFS;

import com.junhua.tornesol.leetcode.datastructure.tree.TreeNode;

import java.util.*;

public class AverageOfLevelsInBinaryTree {

    static public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(sum / size);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3).setLeft(new TreeNode(9))
                .setRight(new TreeNode(20).setLeft(new TreeNode(7)).setRight(new TreeNode(15)));

        List<Double> res = averageOfLevels(root);
        return;
    }


}
