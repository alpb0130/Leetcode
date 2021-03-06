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
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int dp[] = new int[len + 1];
        dp[1] = nums[0];
        for (int i = 2; i < len + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

    // DP. Time complexity: O(n). Space complexity: O(1)
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int pre_pre = 0;
        int pre = nums[0];
        int cur = pre;
        for (int i = 2; i < len + 1; i++) {
            cur = Math.max(pre, pre_pre + nums[i - 1]);
            pre_pre = pre;
            pre = cur;
        }
        return cur;
    }
}
