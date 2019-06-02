package com.junhua.tornesol.util.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * BTS: 所有的左节点小于根节点，所有的右节点大于根节点
 */
public class ValidateBST {


    public static void inOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft(), result);
        result.add(root.getVal());
        inOrder(root.getRight(), result);
    }

    public static boolean isValidateBTS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<Integer> orderedResult = new ArrayList<>();
        inOrder(root, result);
        orderedResult.addAll(result);
        orderedResult.sort((a, b) -> a - b);

        for (int i = 0; i < result.size(); i++) {
            if (!result.get(i).equals(orderedResult.get(i))) {
                return false;
            }
        }
        return true;
    }


    public static boolean isValidateBTS2(TreeNode root, Integer max, Integer min) {
        if (root == null) return true;
        if (min != null && root.getVal() < min) return false;
        if (max != null && root.getVal() > max) return false;
        return isValidateBTS2(root.getLeft(), root.getVal(),min)
                && isValidateBTS2(root.getRight(), max,root.getVal());
    }

    public static void main(String[] args) {
        System.out.print(isValidateBTS(TreeNode.DEFAULT_TREE));
        System.out.print(isValidateBTS2(TreeNode.DEFAULT_TREE, null, null));
    }
}
