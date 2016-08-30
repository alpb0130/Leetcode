import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alpb0130 on 1/5/16.
 * <p>
 * 219. Contains Duplicate II
 * <p>
 * Given an array of integers and an integer k, find out whether there are two distinct
 * indices i and j in the array such that nums[i] = nums[j] and the difference between i
 * and j is at most k.
 * <p>
 * Time complexity: O (n) and O(n)
 * Space complexity: O (n) and O(n)
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) return false;
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                if (i - hash.get(nums[i]) <= k) {
                    return true;
                }
            }
            hash.put(nums[i], i);
        }
        return false;
    }

    // Hashset and sliding window
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}
