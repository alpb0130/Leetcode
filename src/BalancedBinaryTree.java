/**
 * Created by alpb0130 on 9/30/15.
 * <p>
 * Balanced Binary Tree
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as
 * a binary tree in which the depth of the two subtrees of every
 * node never differ by more than 1.
 * <p>
 *
 * Time complexity: O(n) (combine depth computation with balance judgement)
 */

public class BalancedBinaryTree {
    // Return subtree depth and use -1 to represent false
    // Time complexity: O(n)
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalance(root) != -1;
    }

    public int isBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = isBalance(root.left);
        int rh = isBalance(root.right);
        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) {
            return -1;
        }
        int h = Math.max(lh, rh) + 1;
        return h;
    }
}
