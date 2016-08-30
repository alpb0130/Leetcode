import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by alpb0130 on 1/8/16.
 * <p>
 * 287. Find the Duplicate Number
 * <p>
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
 * find the duplicate one.
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n^2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * <p>
 * Time complexity: O(n) and O(nlogn) and O(n)
 * Space complexity: O(n) and O(1) and O(1)
 */
public class FindDuplicateNumber {
    // Hashmap. Use extra space.
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                hash.put(nums[i], hash.get(nums[i]) + 1);
            } else {
                hash.put(nums[i], 1);
            }
        }
        for (Integer i : hash.keySet()) {
            if (hash.get(i) != 1)
                return i;
        }
        return 0;
    }

    // Sort first. O(nlogn). Use constant space.
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return nums[i];
        }
        return nums[0];
    }

    // Find a circle in a linkedList. Two pointer chase.
    public int findDuplicate2(int[] nums) {
        int first = nums[0], second = nums[0];
        while (true) {
            first = nums[first];
            second = nums[nums[second]];
            if (first == second) break;
        }
        second = nums[0];
        while (second != first) {
            first = nums[first];
            second = nums[second];
        }
        return first;
    }
}
