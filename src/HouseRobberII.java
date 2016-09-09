/**
 * Created by alpb0130 on 9/8/16.
 * <p>
 * 213. House Robber II
 * <p>
 * Note: This is an extension of House Robber.
 * <p>
 * After robbing those houses on that street, the thief has found
 * himself a new place for his thievery so that he will not get too
 * much attention. This time, all houses at this place are arranged
 * in a circle. That means the first house is the neighbor of the
 * last one. Meanwhile, the security system for these houses remain
 * the same as for those in the previous street.
 * <p>
 * Given a list of non-negative integers representing the amount of
 * money of each house, determine the maximum amount of money you can
 * rob tonight without alerting the police.
 */
public class HouseRobberII {
    // Get the maximum value from sub-array(0~length-2) and (1 ~ length - 1)
    // Get the maximum value from those two value
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    public int robHelper(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int pre_pre = 0;
        int pre = nums[start];
        int cur = pre;
        for (int i = start + 1; i <= end; i++) {
            cur = Math.max(pre_pre + nums[i], pre);
            pre_pre = pre;
            pre = cur;
        }
        return cur;
    }
}
