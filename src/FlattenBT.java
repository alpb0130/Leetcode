/**
 * Created by alpb0130 on 11/12/15.
 * <p>
 * Flatten Binary Tree to Linked List
 * <p>
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given
 *      1
 *     / \
 *    2   5
 *   / \   \
 *  3   4   6
 * The flattened tree should look like:
 *  1
 *   \
 *   2
 *    \
 *    3
 *     \
 *     4
 *      \
 *      5
 *       \
 *       6
 */

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBT {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            if (node.right != null) {
                nodeStack.push(node.right);
            }
            if (node.left != null) {
                node.right = node.left;
                nodeStack.push(node.left);
                node.left = null;
            }
            if (node.left == null && node.right == null && !nodeStack.isEmpty()) {
                node.right = nodeStack.peek();
            }
        }
    }
    // Recursive style
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten1(root.left);
        flatten1(root.right);
        TreeNode node = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null)
            root = root.right;
        root.right= node;
    }
}
