/**
 * Created by alpb0130 on 9/10/16.
 * <p>
 * 53. Maximum Subarray
 * <p>
 * Find the contiguous subarray within an array (containing at
 * least one number) which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
    // Time: O(n)
    // Space: O(n)
    // DP. T(n) = Max(T(n - 1) + nums[n], nums[n])
    // Tn store the maximum sum that include nums[n]
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // Time: O(n)
    // Space: O(1)
    // Change original array
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= 0) nums[i] += nums[i - 1];
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    // Time: O(n)
    // Space: O(1)
    // Don't change original array
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int pre = nums[0];
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], pre + nums[i]);
            pre = cur;
            max = Math.max(max, cur);
        }
        return max;
    }
}
