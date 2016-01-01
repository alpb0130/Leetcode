import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alpb0130 on 10/2/15.
 * <p>
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1
 * must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * <p>
 * Output: index1=1, index2=2
 */
public class Twosum {
    // Brute force. Time complexity: O(n^2);
    public int[] twoSum(int[] nums, int target) {
        int[] index = {-1, -1};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index[0] = i + 1;
                    index[1] = j + 1;
                }
            }
        }
        if (index[0] != -1)
            return index;
        return null;
    }

    // Better way, sort first and then use two pointers to find the pair, time complexity: O (n * logn)
    public int[] twosum1(int[] nums, int target) {
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int target1 = 0, target2 = 0;
        int[] index = new int[2];
        while (true) {
            if (i >= j) break;
            if (nums[i] + nums[j] == target) {
                target1 = nums[i];
                target2 = nums[j];
                break;
            }
            if (nums[i] + nums[j] < target) i++;
            if (nums[i] + nums[j] > target) j--;
        }
        int l = 0;
        for (int k = 0; k < nums.length; k++) {
            if (numsCopy[k] == target1 || numsCopy[k] == target2) {
                index[l] = k + 1;
                l++;
            }
        }
        return index;
    }
}
