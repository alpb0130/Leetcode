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
 */
public class ValidateBST {
    // Iterative style (if the leftmost node is equal to Integer.MIN_VALUE!!)
    // Inorder traverse
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        boolean isFirst = true;
        int preValue = Integer.MIN_VALUE;
        if (root == null) return true;
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (node.val <= preValue && !isFirst) return false;
                if (isFirst) isFirst = false;
                preValue = node.val;
                node = node.right;
            }
        }
        return true;
    }
    // Recursive style
    public static boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        int preValue = Integer.MIN_VALUE;
        return validBST(root, null, null);
    }

    public static boolean validBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        return validBST(root.left, min, root.val) && validBST(root.right, root.val, max);
    }
}
