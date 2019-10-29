package algorithm.leetcode.datastructure.treereview;

import com.junhua.algorithm.leetcode.datastructure.tree.TreeNode;

public class PathSumIII {


    static public int pathSum(TreeNode root, int sum) {

        if (root == null) return 0;
        return find(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static int find(TreeNode root, int sum) {

        int res = 0;
        if (root == null) return 0;
        if (root.val == sum) res++;
        res += find(root.right, sum - root.val);
        res += find(root.left, sum - root.val);
        return res;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10).setLeft(new TreeNode(5).setLeft(new TreeNode(3).setRight(new TreeNode(3)).setRight(new TreeNode(-2)))
                .setRight(new TreeNode(2).setRight(new TreeNode(1))))
                .setRight(new TreeNode(-3).setRight(new TreeNode(11)));

        System.out.println(pathSum(root, 8));

    }
}
