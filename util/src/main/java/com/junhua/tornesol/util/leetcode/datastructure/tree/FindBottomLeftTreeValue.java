package com.junhua.tornesol.util.leetcode.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {


    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) queue.offer(root.right);
            if (root.left != null) queue.offer(root.left);
        }
        return root.val;
    }

    public static void main(String[]args){

    }
}
