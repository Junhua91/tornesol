package algorithm.leetcode.datastructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    static Stack<TreeNode> stack = new Stack<>();


    static public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        TreeNode currentNode = root;
        while (currentNode != null) {
            stack.push(currentNode);
            if (currentNode.left != null) {
                currentNode = currentNode.left;
            } else break;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                TreeNode curr = node.right;
                while (curr != null) {
                    stack.push(curr);
                    if (curr.left != null) curr = curr.left;
                    else break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1).setRight(new TreeNode(2).setLeft(new TreeNode(3)));

        List<Integer> result = inorderTraversal(root);

        System.out.println();
    }
}
