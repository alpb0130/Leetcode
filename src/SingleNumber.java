import java.util.HashMap;

/**
 * Created by alpb0130 on 1/7/16.
 * <p>
 * 136. Single Number
 * <p>
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Time complexity: O(n) and O(n)
 * Space complexity: O(n) and O(1)
 */
public class SingleNumber {
    // HashMap. Very slow.
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                hash.put(nums[i], hash.get(nums[i]) + 1);
            } else {
                hash.put(nums[i], 1);
            }
        }
        for (Integer i : hash.keySet()) {
            if (hash.get(i) == 1)
                return i;
        }
        return 0;
    }

    // Bit manipulation (exclusive - or)
    public int singleNumber1(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum ^= i;
        }
        return sum;
    }
}
