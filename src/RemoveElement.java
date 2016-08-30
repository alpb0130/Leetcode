/**
 * Created by alpb0130 on 1/3/16.
 *
 * 27. Remove Element
 *
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int l = nums.length;
        if (l == 0) return l;
        int i = 0, left = l;
        while (i < l) {
            if (nums[i] == val) {
                while (l - 1 > i && nums[l - 1] == val) {
                    l--;
                }
                if (l == 0) {
                    break;
                }
                nums[i] = nums[l - 1];
                l--;
            }
            i++;
        }
        return l;
    }
    // More clear method
    public int removeElement1(int[] nums, int val) {
        int l = nums.length;
        if (l == 0) return l;
        int index = 0;
        for (int i = 0; i < l; i++) {
            if (nums[i] != val) {
                if (i != index ) {
                    nums[index] = nums[i];
                }
                index++;
            }
        }
        return ++index;
    }
}
