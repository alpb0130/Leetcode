/**
 * Created by alpb0130 on 1/3/16.
 *
 * 26. Remove Duplicates from Sorted Array
 *
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2
 * respectively. It doesn't matter what you leave beyond the new length.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveDuplicatesFromSortedArray {
    // Not so good because I move the entire left array
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int l = nums.length, curNum = nums[0], step =0;
        for (int i = 1; i < l; i++) {
            if (nums[i] == curNum) {
                step++;
            }
            else {
                System.arraycopy(nums, i, nums, i - step, nums.length - i);
                i -= step;
                l -= step;
                step = 0;
                curNum = nums[i];
            }
        }
        l -= step;
        return l;
    }
    // Improvement
    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[cur]) {
                cur++;
                if (cur != i) {
                    nums[cur] = nums[i];
                }
            }
        }
        return cur + 1;
    }
}
