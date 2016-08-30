import java.util.*;
import java.util.Arrays;

/**
 * Created by alpb0130 on 1/3/16.
 * <p>
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * <p>
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromPreorderInorder {
    // Time complexity: Average - O(n * logn), Best - O(n): right skew, Worst - O(n^2): left skew
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        TreeNode root = new TreeNode(preorder[prestart]);
        if (prestart == preend && instart == inend) return root;
        int in_root = instart;
        while (inorder[in_root] != preorder[prestart]) {
            in_root++;
        }
        int left_l = in_root - instart;
        int right_l = inend - in_root;
        if (left_l != 0) {
            TreeNode left = helper(preorder, prestart + 1, prestart + left_l, inorder, instart, in_root - 1);
            root.left = left;
        }
        if (right_l != 0) {
            TreeNode right = helper(preorder, preend - right_l + 1, preend, inorder, in_root + 1, inend);
            root.right = right;
        }
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}

        TreeNode(int x) {
            val = x;
            left =null;
            right = null;
        }
        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
        void addLeftCld(TreeNode left) {
            this.left = left;
        }
        void  addRightCld(TreeNode right) {
            this.right = right;
        }
    }
}
