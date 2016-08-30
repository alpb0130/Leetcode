import java.util.Arrays;

/**
 * Created by alpb0130 on 1/8/16.
 * <p>
 * 268. Missing Number
 * <p>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * <p>
 * Time complexity: O(nlogn) and O(n) and O(n)
 * Space complexity: O(1) and O(1) and O(1)
 */
public class MissingNumber {
    // Sort first.
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return nums.length;
    }

    // More efficient way.
    public int missingNumber1(int[] nums) {
        int max = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int ssum = max * (max + 1) / 2;
        return ssum - sum;
    }

    // Bit manipulation.
    public int missingNumber2(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret ^= (i ^ nums[i]);
        }
        return ret ^ nums.length;
    }
}
