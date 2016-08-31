/**
 * Created by alpb0130 on 10/30/15.
 * <p>
 * Unique Binary Search Trees
 * <p>
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *  1         3     3      2      1
 *   \       /     /      / \      \
 *    3     2     1      1   3      2
 *   /     /       \                 \
 *  2     1         2                 3
 * <p>
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class UniqueBinarySearchTrees {
    // May work, but time exceed limitation.
    public int numTrees1(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 3;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numTrees1(i - 1) * numTrees1(n - i);
        }
        return sum;
    }

    // DP
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
