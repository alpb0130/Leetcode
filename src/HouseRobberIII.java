/**
 * Created by alpb0130 on 9/9/16.
 * <p>
 * 337. House Robber III
 * <p>
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root." Besides
 * the root, each house has one and only one parent house. After a tour,
 * the smart thief realized that "all houses in this place forms a binary
 * tree". It will automatically contact the police if two directly-linked
 * houses were broken into on the same night.
 * <p>
 * Determine the maximum amount of money the thief can rob tonight without
 * alerting the police.
 * <p>
 * Example 1:
 *      3
 *     / \
 *    2   3
 *    \   \
 *    3   1
 * <p>
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * <p>
 * Example 2:
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobberIII {
    // Recursive style. DP
    // Time complexity: O(n)
    // Space complexity: O(n)
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] res = robHelper(root);
        return Math.max(res[0], res[1]);

    }

    public int[] robHelper(TreeNode root) {
        int[] res = new int[2];
        int[] left = new int[2];
        int[] right = new int[2];
        if (root.left == null && root.right == null) {
            res[1] = root.val;
            return res;
        }
        if (root.left != null) left = robHelper(root.left);
        if (root.right != null) right = robHelper(root.right);
        res[0] =Math.max(left[1], left[0]) + Math.max(right[1], right[0]);
        res[1] = Math.max(left[0] + right[0] + root.val, res[0]);
        return res;
    }
}
