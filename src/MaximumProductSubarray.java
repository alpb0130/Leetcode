/**
 * Created by alpb0130 on 9/10/16.
 * <p>
 * 152. Maximum Product Subarray
 * <p>
 * Find the contiguous subarray within an array (containing
 * at least one number) which has the largest product.
 * <p>
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {
    // DP.
    // Time: O(n)
    // Space: O(1)
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // If current num is smaller that 0, exchange max and min.
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            // Math.min and Math.max is to deal with the condition where
            // current num is equal to 01
            min = Math.min(min * nums[i], nums[i]);
            max = Math.max(max * nums[i], nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
