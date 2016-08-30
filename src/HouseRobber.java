/**
 * Created by alpb0130 on 2/22/16.
 * <p>
 * 198. House Robber
 * <p>
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have security
 * system connected and it will automatically contact the police if two
 * adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money
 * of each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 */
public class HouseRobber {
    // DP. Time complexity: O(n). Space complexity: O(n)
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i - 1], dp[i - 2]) + nums[i];
        }
        return Math.max(dp[nums.length], dp[nums.length - 1]);
    }

    // DP. Time complexity: O(n). Space complexity: O(n)
    public int rob1(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int prev_prev = 0;
        int prev = nums[0];
        int now = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int temp = now;
            now = Math.max(prev, prev_prev) + nums[i];
            prev_prev = prev;
            prev = temp;
        }
        return Math.max(now, prev);
    }
}
