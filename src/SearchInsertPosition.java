/**
 * Created by alpb0130 on 1/7/16.
 *
 * 35. Search Insert Position
 *
 * Given a sorted array and a target value, return the index if the target
 * is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {
    // O(n)
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }

    // O(logn). Binary search.
    public int searchInsert1(int[] nums, int target) {
        int lower = 0, upper = nums.length - 1;
        while (true) {
            if (lower > upper) break;
            int mid = (upper + lower) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) lower = mid + 1;
            if (nums[mid] > target) upper = mid - 1;
        }
        return lower;
    }
}
