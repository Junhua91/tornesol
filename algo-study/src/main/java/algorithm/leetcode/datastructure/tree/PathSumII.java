package algorithm.leetcode.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public static List<List<Integer>> result = new ArrayList<>();

    static public List<List<Integer>> pathSum(TreeNode root, int sum) {

        find(root, sum, new ArrayList<>());

        return result;

    }

    public static void find(TreeNode root, int sum, List<Integer> result1) {

        if (root == null) return;
        result1.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(result1));
            return;
        }
        if (root.left != null) {
            find(root.left, sum - root.val, result1);
            result1.remove(result1.size() - 1);
        }

        if (root.right != null) {
            find(root.right, sum - root.val, result1);
            result1.remove(result1.size() - 1);
        }
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(5).setLeft(new TreeNode(4).setLeft(new TreeNode(11).setLeft(new TreeNode(7)).setRight(new TreeNode(2))))
                .setRight(new TreeNode(8).setLeft(new TreeNode(13)).setRight(new TreeNode(4).setLeft(new TreeNode(5)).setRight(new TreeNode(1))));

        List<List<Integer>> result = pathSum(root, 22);

        System.out.println();
    }
}
