package algorithm.leetcode.datastructure.treereview.BST;

import com.junhua.algorithm.leetcode.datastructure.tree.TreeNode;

import java.util.Stack;

public class KthSmallestElementInBST {


    static public int kthSmallest(TreeNode root, int k) {
        int[] resList = new int[k];
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            resList[index++] = root.val;
            root = root.right;
            if (index == k) break;
        }
        return resList[k - 1];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3).setLeft(new TreeNode(1).setRight(new TreeNode(2)))
                .setRight(new TreeNode(4));

        System.out.println(kthSmallest(root,2));
    }

}
