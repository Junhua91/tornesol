package com.junhua.algorithm.offer;


/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */
public class NowCoder17 {

    static public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return find(root1, root2) || find(root1.left, root2) || find(root1.right, root2);
    }

    public static boolean find(TreeNode p, TreeNode q) {
        if (q == null) return true;
        if (p == null||p.val != q.val) return false;
        return find(p.left, q.left) && find(p.right, q.right);
    }
}
