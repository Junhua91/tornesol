package com.junhua.algorithm.leetcode.datastructure.treereview.BFS;

import com.junhua.algorithm.leetcode.datastructure.tree.TreeNode;

import java.util.*;

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
}
