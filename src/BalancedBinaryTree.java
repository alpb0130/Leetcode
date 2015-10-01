/**
 * Created by alpb0130 on 9/30/15.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSubtreeBalanced(root.left, root.right);
    }

    public boolean isSubtreeBalanced(TreeNode leftChild, TreeNode rightChild) {
        if (leftChild == null && rightChild == null) {
            return true;
        }
        if (leftChild != null && rightChild == null) {
            return leftChild.left == null && leftChild.right == null;
        }
        if (leftChild == null && rightChild != null) {
            return rightChild.left == null && rightChild.right == null;
        }
        return isSubtreeBalanced(leftChild.left, leftChild.right)
                && isSubtreeBalanced(rightChild.left, rightChild.right)
                && (Math.abs(treeDepth(leftChild) - treeDepth(rightChild)) <= 1);
    }

    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}
