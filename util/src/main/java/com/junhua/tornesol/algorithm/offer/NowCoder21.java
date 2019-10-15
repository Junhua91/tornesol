package com.junhua.tornesol.algorithm.offer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class NowCoder21 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> res = new ArrayList<>();

        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) queue.offer(root.left);
            if (node.right != null) queue.offer(root.right);
        }
        return res;
    }
}
