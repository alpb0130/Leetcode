/**
 * Created by alpb0130 on 9/30/15.
 * <p>
 * Symmetric Tree
 * <p>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 *      1
 *     / \
 *    2   2
 *   / \ / \
 *  3  4 4  3
 * But the following is not:
 *      1
 *     / \
 *    2   2
 *    \   \
 *    3    3
 * <p>
 * Time complexity O(n).
 * The solution is written iteratively and recursively.
 */

import java.util.Stack;

public class SymmetricTree {
    // recursive style
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSubSymmetric(root.left, root.right);
    }

    public boolean isSubSymmetric(TreeNode leftChild, TreeNode rightChild) {
        if (leftChild == null && rightChild == null) {
            return true;
        }
        if (leftChild != null && rightChild != null) {
            return (leftChild.val == rightChild.val)
                    && isSubSymmetric(leftChild.left, rightChild.right)
                    && isSubSymmetric(leftChild.right, rightChild.left);
        }
        return false;
    }

    // Iterative style
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root.left);
            stack.push(root.right);
            while (!stack.empty()) {
                TreeNode node1 = stack.pop();
                TreeNode node2 = stack.pop();
                if (node1.val != node2.val) {
                    return false;
                }
                if ((node1.left != null && node2.right == null) || (node1.left == null && node2.right != null)) {
                    return false;
                }
                if (node1.right != null && node2.left == null || (node1.right == null && node2.left != null)) {
                    return false;
                }
                if (node1.left != null && node2.right != null) {
                    stack.push(node1.left);
                    stack.push(node2.right);
                }
                if (node1.right != null && node2.left != null) {
                    stack.push(node1.right);
                    stack.push(node2.left);
                }
            }
            return true;
        }
        return false;
    }
}
