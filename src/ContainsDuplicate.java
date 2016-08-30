import java.util.HashMap;

/**
 * Created by alpb0130 on 1/3/16.
 *
 * 217. Contains Duplicate
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in
 * the array, and it should return false if every element is distinct.
 *
 * Time Complexity: O(n) and O(n)
 * Space Complexity: O(n) and O(1)
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) return false;
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i : nums) {
            Integer value = new Integer(i);
            if (hash.get(value) == null) {
                hash.put(value, 1);
            } else {
                return true;
            }
        }
        return false;
    }
    // Bit manipulation
    public boolean containsDuplicate1(int[] nums) {
        if (nums.length == 0) return false;
        byte[] flag = new byte[150000];
        for (int i : nums) {
            int index = i / 8;
            int pos = i % 8;
            int check = 1 << pos;
            if ((flag[index] & check) != 0) {
                return true;
            }
            flag[index] |= check;
        }
        return false;
    }
}
