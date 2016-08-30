import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by alpb0130 on 1/8/16.
 *
 * 260. Single Number III
 *
 * Given an array of numbers nums, in which exactly two elements appear
 * only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 *
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant space complexity?
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        // Hashmap.
        ArrayList<Integer> list = new ArrayList<Integer>();
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
                list.add(i);
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
