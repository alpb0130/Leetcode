/**
 * Created by alpb0130 on 9/11/16.
 * <p>
 * 156. Binary Tree Upside Down
 * <p>
 * Given a binary tree where all the right nodes are either leaf
 * nodes with a sibling (a left node that shares the same parent node)
 * or empty, flip it upside down and turn it into a tree where the
 * original right nodes turned into left leaf nodes. Return the new root.
 * <p>
 * For example:
 * Given a binary tree {1,2,3,4,5},
 *          1
 *         / \
 *        2   3
 *       / \
 *      4   5
 * return the root of the binary tree [4,5,2,#,#,3,1].
 *          4
 *         / \
 *        5   2
 *       / \
 *      3   1
 */
public class BuildTreeUpsideDown {
    // Recursive.
    // Time: O(n)
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode left = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return left;
    }
}
