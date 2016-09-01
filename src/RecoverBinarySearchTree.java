import java.util.Stack;

/**
 * Created by alpb0130 on 8/31/16.
 *
 * 99. Recover Binary Search Tree
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree {
    // Inorder traversal to find the two swapped node
    // After finding them, swap their values
    // Pay attention to the condition of swapping the parent and child
    // This would be tricky to set the node pointer
    // Basic idea is to find the node whose value is smaller than the previous one
    // e.g. 1 2 3 4 5 6 7 8 (original)
    // case 1. 1 7 3 4 5 6 2 8 (one pre and one current)
    // case 2. 1 2 4 3 5 6 7 8 (pre and current)
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode pre = null;
        TreeNode targetA = null, targetB = null;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (pre != null && node.val <= pre.val) {
                    // Would cover both case 1 and case 2
                    if (targetA == null) targetA = pre;
                    if (targetA != null) targetB = node;
                }
                pre = node;
                node = node.right;
            }
        }
        swap(targetA, targetB);
        return;
    }

    public void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
