package algorithm.leetcode.datastructure.tree.construct_tree;

import com.junhua.algorithm.leetcode.datastructure.tree.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    static public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        return find(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    static public TreeNode find(int[] postOrder, int pStart, int pEnd, int[] inOrder, int iStart, int iEnd) {
        if (pStart > pEnd) return null;
        int index = iStart;
        while (postOrder[pEnd] != inOrder[index]) {
            index++;
        }
        TreeNode root = new TreeNode(postOrder[pEnd]);
        root.left = find(postOrder, pStart, pStart + index - iStart - 1, inOrder, iStart, index - 1);
        root.right = find(postOrder, pStart + index - iStart, pEnd - 1, inOrder, index + 1, iEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] postOrder = {9, 15, 7, 20, 3};
        int[] inOrder = {9, 3, 15, 20, 7};

        TreeNode res = buildTree(inOrder, postOrder);
        return;
    }
}
