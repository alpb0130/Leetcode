import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by alpb0130 on 1/2/16.
 * <p>
 * Sum Root to Leaf Numbers
 * <p>
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *      1
 *     / \
 *    2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 * <p>
 * Time Complexity: O(n)
 */
public class SumRootToLeafNumbers {
    // Recursive style. Time complexity: O(n)
    public int sumNumbers1(TreeNode root) {
        return getSum(root, 0);
    }

    public int getSum(TreeNode root, int sum) {
        if (root == null) return 0;
        sum += root.val;
        if (root.left == null && root.right == null) return sum;
        return getSum(root.left, sum * 10) + getSum(root.right, sum * 10);
    }

    // Iterative style
    public int sumNumbers2(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> valStack = new Stack<Integer>();
        stack.push(root);
        valStack.push(root.val);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int val = valStack.pop();
            if (node.right == null && node.left == null) {
                sum += val;
            }
            if (node.right != null) {
                stack.push(node.right);
                valStack.push(val * 10 + node.right.val);
            }
            if (node.left != null) {
                stack.push(node.left);
                valStack.push(val * 10 + node.left.val);
            }
        }
        return sum;
    }
}
