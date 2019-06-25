package com.junhua.tornesol.util.leetcode.tree;

import java.util.Objects;

public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode setLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode setRight(TreeNode right) {
        this.right = right;
        return this;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public static TreeNode DEFAULT_TREE = new TreeNode(3)
            .setLeft(
                    new TreeNode(1).setRight(
                            new TreeNode(2)
                    )
            ).setRight(new TreeNode(5));

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
