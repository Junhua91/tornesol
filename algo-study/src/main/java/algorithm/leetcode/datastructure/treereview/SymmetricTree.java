package algorithm.leetcode.datastructure.treereview;

import com.junhua.algorithm.leetcode.datastructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    static public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    static public boolean isSymmetric2(TreeNode root) {

        if (root == null) return true;

        TreeNode left = root.left;
        TreeNode right = root.right;
        return find(left, right);
    }

    static public boolean find(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return find(left.left, right.right) && find(left.right, right.left);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1).setLeft(new TreeNode(2).setRight(new TreeNode(4)).setLeft(new TreeNode(3)))
                .setRight(new TreeNode(2).setLeft(new TreeNode(4)).setRight(new TreeNode(3)));

        TreeNode root2 = new TreeNode(1).setLeft(new TreeNode(2).setLeft(new TreeNode(2)))
                .setRight(new TreeNode(2).setLeft(new TreeNode(2)));
        System.out.println(isSymmetric(root));
        System.out.println(isSymmetric2(root));
    }
}
