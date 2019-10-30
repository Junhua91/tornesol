package com.junhua.algorithm.leetcode.datastructure.tree;

import java.util.*;

/**
 * BFS: 广度优先搜索
 * DFS：深度优先搜索
 */
public class LevelOrder {

    private static TreeNode TEST_TREE = new TreeNode(3)
            .setRight(new TreeNode(20).setLeft(new TreeNode(15)).setRight(new TreeNode(7)))
            .setLeft(new TreeNode(9).setLeft(new TreeNode(21)));


    /**
     * BFS 模版：使用queue
     *
     * @param root
     * @return
     */
    private static List<List<Integer>> find(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.getVal());
                if (node.getLeft() != null) queue.offer(node.getLeft());
                if (node.getRight() != null) queue.offer(node.getRight());
            }
            result.add(currentLevel);
        }
        return result;
    }


    /**
     * DFS: 使用Stack或者递归函数
     *
     * @param root
     * @param level
     * @param result
     */
    private static void find2(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (result.size() < level + 1) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.getVal());
        find2(root.getLeft(), level + 1, result);
        find2(root.getRight(), level + 1, result);
    }

    private static void find3(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
                level++;
            }
            if (level > result.size()) {
                for (int i = result.size(); i < level; i++) {
                    result.add(new ArrayList<>());
                }
            }
            root = stack.pop();
            result.get(level - 1).add(root.val);
            level--;
            TreeNode right = root.right;
            if(right!=null)level++;
            root =right;
        }
    }

    static public void main(String[] args) {

        List<List<Integer>> result = find(TEST_TREE);
        List<List<Integer>> result2 = new ArrayList<>();
        List<List<Integer>> result3 = new ArrayList<>();

        printList(result);
        System.out.println("----------");

        find2(TEST_TREE, 0, result2);
        find3(TEST_TREE, 0, result3);
        printList(result2);
        printList(result3);

    }

    static public void printList(List<List<Integer>> result) {
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j));
            }
            System.out.println();
        }
    }
}
