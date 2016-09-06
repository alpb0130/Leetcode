/**
 * Created by alpb0130 on 11/12/15.
 * <p>
 * Flatten Binary Tree to Linked List
 * <p>
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBT {
    // Iterative style
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            if (!stack.isEmpty()) node.right = stack.peek();
            node.left = null;
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
        root.right = node;
    }

    //  Recursive style without halfway traversal
    // In flatten1, we need to traverse the tree to find the leaf of original left subtree
    // Here, no need to do additional traversal. When the program recursive call the function,
    // use a global var to note down the current visited node and the last node would be there.
    TreeNode prev = null;

    public void flatten3(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    // Recursive style with helper function
    public void flatten2(TreeNode root) {
        if (root == null) return;
        flattenHelper(root);
    }

    public TreeNode flattenHelper(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode temp = root.right;
        TreeNode node = null;
        if (root.left != null) {
            root.right = root.left;
            root.left = null;
            node = flattenHelper(root.right);
            node.right = temp;
        }
        if (temp != null)
            node = flattenHelper(temp);
        return node;
    }
}
