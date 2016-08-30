/**
 * Created by alpb0130 on 1/6/16.
 * <p>
 * 63. Unique Paths II
 * <p>
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 * <p>
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 */
public class UniquePathII {
    // DP. O(n) space. O(m * n) time.
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[j] = 0;
                else {
                    dp[j] += j == 0 ? 0 : dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

    // DP. O(n) space
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) dp[0] = 0;
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) dp[j] = 0;
                else dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
