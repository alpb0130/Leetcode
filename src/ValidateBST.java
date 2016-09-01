import java.util.Stack;

/**
 * Created by alpb0130 on 1/1/16.
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Time complexity: O(n)
 */
public class ValidateBST {
    // Iterative style (if the leftmost node is equal to Integer.MIN_VALUE!!)
    // Inorder traverse
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (pre != null && node.val <= pre.val) return false;
                pre = node;
                node = node.right;
            }
        }
        return true;
    }

    // Recursive style
    public static boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        return validBST(root, null, null);
    }

    public static boolean validBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        return validBST(root.left, min, root.val) && validBST(root.right, root.val, max);
    }
}
