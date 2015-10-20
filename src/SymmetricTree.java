/**
 * Created by alpb0130 on 9/30/15.
 *
 * Symmetric Tree
 *
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
 *
 * Time complexity O(n)
 *
 */

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
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
}
