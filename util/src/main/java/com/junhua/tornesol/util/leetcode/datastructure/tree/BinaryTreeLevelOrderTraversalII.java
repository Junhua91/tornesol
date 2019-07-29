package com.junhua.tornesol.util.leetcode.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {


    static public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        find(root, 0, result);

        return result;
    }


    public static void find(TreeNode root, int level, List<List<Integer>> result) {

        if (root == null) return;

        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }

        find(root.left, level + 1, result);
        find(root.right, level + 1, result);

        result.get(level).add(root.val);
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();


        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> elements = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                elements.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(elements);
        }
        return result;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3).setLeft(new TreeNode(9))
                .setRight(new TreeNode(20).setLeft(new TreeNode(15)).setRight(new TreeNode(7)));

        List list = levelOrder(root);
        System.out.println();
    }
}
