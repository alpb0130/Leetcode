/**
 * Created by alpb0130 on 9/4/16.
 * <p>
 * 124. Binary Tree Maximum Path Sum
 * <p>
 * Given a binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.
 * <p>
 * For example:
 * Given the below binary tree,
 *      1
 *     / \
 *   2   3
 * Return 6.
 */
public class BinaryTreeMaximumPathSum {
    // Recursive style.
    // Time complexity: O(n)
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        pathHelper(root);
        return max;
    }

    public int pathHelper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, pathHelper(root.left));
        int right = Math.max(0, pathHelper(root.right));
        int cur = root.val + left + right;
        max = cur > max ? cur : max;
        return Math.max(left, right) + root.val;

    }
}
