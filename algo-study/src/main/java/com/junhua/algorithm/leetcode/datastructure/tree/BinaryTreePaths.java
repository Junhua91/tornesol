package com.junhua.algorithm.leetcode.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {


    static public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        if (root != null) {
            find(root, result, "");
        }

        return result;
    }


    public static void find(TreeNode root, List<String> result, String path) {
        if (root != null && root.left == null && root.right == null) {
            result.add(path + root.val);
        }

        if (root.left != null) find(root.left, result, path + root.val + "->");
        if (root.right != null) find(root.right, result, path + root.val + "->");
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1).setLeft(new TreeNode(2).setRight(new TreeNode(5)))
                .setRight(new TreeNode(3));

        List<String> result = binaryTreePaths(root);

        result.forEach(p -> System.out.println(p));
    }

}
