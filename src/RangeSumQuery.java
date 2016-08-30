/**
 * Created by alpb0130 on 2/22/16.
 * <p>
 * 303. Range Sum Query - Immutable
 * <p>
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class RangeSumQuery {
    int[] nums;

    public RangeSumQuery(int[] nums) {
        if (nums.length == 0)
            this.nums = nums;
        else {
            this.nums = new int[nums.length];
            this.nums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                this.nums[i] = this.nums[i - 1] + nums[i];

            }
        }

    }

    public int sumRange(int i, int j) {
        if (i == 0) return this.nums[j];
        else return this.nums[j] - this.nums[i - 1];
    }
}
