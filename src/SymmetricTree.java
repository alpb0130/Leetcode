/**
 * Created by alpb0130 on 9/30/15.
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
