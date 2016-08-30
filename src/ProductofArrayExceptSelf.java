/**
 * Created by alpb0130 on 2/25/16.
 * <p>
 * 238. Product of Array Except Self
 * <p>
 * Given an array of n integers where n > 1, nums, return an array output
 * such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Solve it without division and in O(n).
 * <p>
 * For example, given [1,2,3,4], return [24,12,8,6].
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not
 * count as extra space for the purpose of space complexity analysis.)
 */
public class ProductofArrayExceptSelf {
    // Time complexity: O(n). Space complexity:O(1)
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 0) return null;
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = (i == 0) ? 1 : ret[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ret[i] = (i == nums.length - 1) ? 1 * ret[i] : ret[i] * right;
            right *= nums[i];
        }
        return ret;
    }
}
