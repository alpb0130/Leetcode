/**
 * Created by alpb0130 on 2/22/16.
 * <p>
 * 70. Climbing Stairs
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    // 1D DP. Time: O(n). Space: O(n)
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    // 1D DP. Time: O(n). Space: O(1)
    public int climbStairs1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int step_2 = 1;
        int step_1 = 1;
        int cur = step_1;
        for (int i = 2; i < n + 1; i++) {
            cur = step_1 + step_2;
            step_2 = step_1;
            step_1 = cur;
        }
        return cur;
    }
}
