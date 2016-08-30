import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by alpb0130 on 1/5/16.
 * <p>
 * 169. Majority Element
 * <p>
 * Given an array of size n, find the majority element. The majority element
 * is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * <p>
 * Time complexity: O(n) and O(nlogn) and O(n) and O(k * n)
 * Space complexity: O(n) and O(1) and O(1) and O(1)
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int bound = nums.length / 2;
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i : nums) {
            int num;
            if (hash.containsKey(i)) {
                num = hash.get(i) + 1;
                hash.put(i, num);
            } else {
                num = 1;
                hash.put(i, num);
            }
            if (num > bound) return i;
        }
        return nums[0];
    }
    // Sort and get the mid-value
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    // Moore voting algorithm
    public int majorityElement2(int[] nums) {
        int count = 1, ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != ret) {
                count--;
            } else {
                count++;
            }
            if (count == 0) {
                ret = nums[i];
                count = 1;
            }
        }
        return ret;
    }
    // Bit manipulation
    public int majorityElement3(int[] nums) {
        int[] bits = new int[32];
        int ret = 0;
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += num >> (31 - i) & 1;
            }
        }
        for (int i = 0; i < 32; i++) {
            if (bits[i] > nums.length / 2)
                ret += 1 << (31 - i);
        }
        return ret;
    }
}
