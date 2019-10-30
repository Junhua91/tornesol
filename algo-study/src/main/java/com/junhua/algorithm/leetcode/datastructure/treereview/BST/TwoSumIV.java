package com.junhua.algorithm.leetcode.datastructure.treereview.BST;

import com.junhua.algorithm.leetcode.datastructure.tree.TreeNode;

import java.util.*;

public class TwoSumIV {

    static public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        List<Integer> list = findNums(root);
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int startVal = list.get(start);
            int endVal = list.get(end);

            if ((startVal + endVal) == k) return true;

            else if ((startVal + endVal) > k) end--;
            else start++;
        }
        return false;
    }

    public static List<Integer> findNums(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }


    static public boolean findTarget2(TreeNode root, int k) {
        if (root == null) return false;
        Set<Integer> set = new HashSet<>();
        return find2(root, set, k);
    }

    static public boolean find2(TreeNode root, Set<Integer> set, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return find2(root.left, set, k) || find2(root.right, set, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5).setLeft(new TreeNode(3).setLeft(new TreeNode(2)).setRight(new TreeNode(4)))
                .setRight(new TreeNode(6).setRight(new TreeNode(7)));

//        System.out.println(findTarget(root,5));
        System.out.println(findTarget(root, 23));
    }
}
