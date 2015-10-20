/**
 * Created by alpb0130 on 9/30/15.
 * Time complexity: O(n^2)
 */

public class BalancedBinaryTree {
    //    public boolean isBalanced(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        return isSubtreeBalanced(root.left, root.right);
//    }
//
//    public boolean isSubtreeBalanced(TreeNode leftChild, TreeNode rightChild) {
//        if (leftChild == null && rightChild == null) {
//            return true;
//        }
//        if (leftChild != null && rightChild == null) {
//            return leftChild.left == null && leftChild.right == null;
//        }
//        if (leftChild == null && rightChild != null) {
//            return rightChild.left == null && rightChild.right == null;
//        }
//        return isSubtreeBalanced(leftChild.left, leftChild.right)
//                && isSubtreeBalanced(rightChild.left, rightChild.right)
//                && (Math.abs(treeDepth(leftChild) - treeDepth(rightChild)) <= 1);
//    }
//
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
