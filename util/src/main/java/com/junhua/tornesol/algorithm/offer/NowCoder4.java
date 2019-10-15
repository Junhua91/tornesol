package com.junhua.tornesol.algorithm.offer;


/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class NowCoder4 {

    static public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) return null;

        TreeNode root = new TreeNode(pre[0]);

        for (int mid : pre) {

        }

        return null;

    }

    public static int findIndex(int[] in, int target) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == target) return i;
        }
        return -1;
    }

    public static TreeNode find(int[] nodes, int cur) {
        if (nodes == null) return new TreeNode(cur);

        return null;
    }
}
