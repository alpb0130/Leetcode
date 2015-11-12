/**
 * Created by alpb0130 on 11/11/15.
 * <p>
 * Range Sum Query - Immutable
 * <p>
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * <p>
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 * <p>
 * Time complexity: Construction: O (n)   Sum: O (1)
 * Space complexity: O (n)
 */
public class NumArray {
    int[] nums;

    public NumArray(int[] nums) {
        if (nums.length <= 1)
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

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
