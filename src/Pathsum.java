import java.util.Stack;

/**
 * Created by alpb0130 on 9/24/15.
 *
 * Path Sum
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf
 * path such that adding up all the values along the path equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *          5
 *         / \
 *        4   8
 *       /   / \
 *      11  13  4
 *     /  \      \
 *    7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * Time complexity best O (log n ), worst O (n), average O (n)
 * Space complexity is O (log n) for iterative method
 *
 */
public class Pathsum {

    // Recursive style
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.val == sum && (root.left == null && root.right == null))
            return true;
        return hasPathSum1(root.left, sum - root.val)
                || hasPathSum1(root.right, sum - root.val);
    }

    // Iterative style (DFS)
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> stackSum = new Stack<Integer>();
        stack.push(root);
        stackSum.push(sum);
        while (!stack.empty()) {
            int sumTemp = stackSum.pop();
            TreeNode node = stack.pop();
            sumTemp -= node.val;
            if (sumTemp == 0 && node.left == null && node.right == null) {
                return true;
            }
            if (node.left != null) {
                stack.push(node.left);
                stackSum.push(sumTemp);
            }
            if (node.right != null) {
                stack.push(node.right);
                stackSum.push(sumTemp);
            }
        }
        return false;
    }
}
