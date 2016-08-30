/**
 * Created by alpb0130 on 1/5/16.
 *
 * 62. Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Time complexity: O(m * n) and O(min(m, n))
 * Space complexity: O(m * n) and O(1)
 */
public class UniquePaths {
    // DP. Iterative style. Assume m > 0 and n > 0.
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++)
            matrix[i][0] = 1;
        for (int i = 0; i < n; i++)
            matrix[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j];
            }
        }
        return matrix[m - 1][n - 1];
    }
    // Combination method (overflow...choose proper data type)
    public int uniquePaths1(int m, int n) {
        int num = Math.min(m, n);
        long ret = 1;
        for (int i = 1; i < num; i++) {
            ret = ret * (m + n - i - 2) / i;
        }
        return Math.toIntExact(ret);
    }
    // DP. O(n) space
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n;j++) {
                dp[i] += dp[i - 1];
            }
        }
        return dp[n - 1];
    }
}
