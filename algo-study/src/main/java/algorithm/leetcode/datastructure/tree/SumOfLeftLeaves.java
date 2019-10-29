package algorithm.leetcode.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3).setLeft(new TreeNode(9))
                .setRight(new TreeNode(20).setLeft(new TreeNode(15)).setRight(new TreeNode(7)));
        System.out.println(sumOfLeftLeaves2(root));
    }

    static public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null || root.left == null) return 0;
        return root.left.val + sumOfLeftLeaves1(root.left) + sumOfLeftLeaves1(root.right);
    }


    static public int sumOfLeftLeaves2(TreeNode root) {

        if (root == null || root.left == null || root.right == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();

        int sum = 0;

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                sum += node.left.val;
            }
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }


        return sum;

    }
}
