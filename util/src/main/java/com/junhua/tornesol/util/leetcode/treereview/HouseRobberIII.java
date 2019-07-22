package com.junhua.tornesol.util.leetcode.treereview;

import com.junhua.tornesol.util.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {

    static public int rob(TreeNode root) {
        if (root == null) return 0;
        int val1 = root.val;
        val1 += (root.left != null) ? rob(root.left.left) + rob(root.left.right) : 0;
        val1 += (root.right != null) ? rob(root.right.left) + rob(root.right.right) : 0;
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
    }

    static public int rob2(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        return find(root, map);
    }

    public static int find(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        if (root == null) return 0;
        int val1 = root.val;
        val1 += (root.left != null) ? find(root.left.left, map) + find(root.left.right, map) : 0;
        val1 += (root.right != null) ? find(root.right.left, map) + find(root.right.right, map) : 0;
        int val2 = find(root.left, map) + find(root.right, map);
        int val = Math.max(val1, val2);
        map.put(root, val);
        return val;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(3).setLeft(new TreeNode(2).setRight(new TreeNode(3)))
                .setRight(new TreeNode(3).setRight(new TreeNode(1)));

        System.out.println(rob(root));
        System.out.println(rob2(root));

    }
}
