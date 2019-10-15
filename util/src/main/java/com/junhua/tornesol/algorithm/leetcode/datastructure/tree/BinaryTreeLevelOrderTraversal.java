package com.junhua.tornesol.algorithm.leetcode.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3).setLeft(new TreeNode(9))
                .setRight(new TreeNode(20).setLeft(new TreeNode(15)).setRight(new TreeNode(7)));

        List<List<Integer>> result = levelOrderBottom2(root);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


    static public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> _result = new ArrayList<>();
        find(root, 0, result);

        for (int i = result.size() - 1; i >= 0; i--) {
            _result.add(result.get(i));
        }
        return _result;
    }


    static public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> result = find2(root);
        List<List<Integer>> _result = new ArrayList<>();

        for (int i = result.size() - 1; i >= 0; i--) {
            _result.add(result.get(i));
        }
        return _result;
    }

    /**
     * DFS
     *
     * @param root
     * @param level
     * @param result
     */
    public static void find(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) return;
        if (result.size() < level + 1) result.add(new ArrayList<>());

        find(root.left, level + 1, result);
        find(root.right, level + 1, result);
        result.get(level).add(root.val);
    }


    /**
     * BFS
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> find2(TreeNode root) {

        if (root == null) return null;

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(list);
        }
        return result;
    }




}
