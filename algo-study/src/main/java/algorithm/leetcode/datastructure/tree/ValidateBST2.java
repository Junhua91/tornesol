package algorithm.leetcode.datastructure.tree;

import java.util.Stack;

public class ValidateBST2 {

    static public boolean isValidBST(TreeNode root) {

        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val > root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    static public boolean find(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val < min) return false;
        if (max != null && root.val > max) return false;
        return find(root.left, min, root.val) && find(root.right, root.val, max);
    }


    public static void main(String[] args) {
        System.out.print(isValidBST(TreeNode.DEFAULT_TREE));
        System.out.print(find(TreeNode.DEFAULT_TREE, null, null));
    }

}

