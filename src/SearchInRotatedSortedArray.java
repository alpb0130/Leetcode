/**
 * Created by alpb0130 on 1/10/16.
 * <p>
 * 33. Search in Rotated Sorted Array
 * <p>
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 * Time complexity: O(logn) and O(n + logn)
 * Space complexity: O(1) and O(1)
 */
public class SearchInRotatedSortedArray {
    // Binary search.
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int lower = 0, upper = nums.length - 1;
        while (true) {
            if (lower > upper) break;
            int mid = (lower + upper) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                if (nums[mid] > nums[upper]) {
                    lower = mid + 1;
                } else {
                    if (nums[upper] >= target)
                        lower = mid + 1;
                    else
                        upper = mid - 1;
                }
            }
            if (nums[mid] > target) {
                if (nums[mid] > nums[upper]) {
                    if (nums[upper] >= target)
                        lower = mid + 1;
                    else
                        upper = mid - 1;
                } else {
                    upper = mid - 1;
                }
            }
        }
        return -1;
    }
    // Find peak and then binary search.
    public int search1(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int peak = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                peak = i;
        }
        if (nums[peak] == target) return peak;
        int pos1 = binarySearch(nums, target, 0, peak);
        int pos2 = binarySearch(nums, target, peak + 1, nums.length - 1);
        if (pos1 != -1) return pos1;
        if (pos2 != -1) return pos2;
        return -1;
    }
    public int binarySearch(int[] nums, int target, int lower, int upper) {
        while (true) {
            if (lower > upper) break;
            int mid = (lower + upper) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
               lower = mid + 1;
            }
            if (nums[mid] > target) {
                upper = mid - 1;
            }
        }
        return -1;
    }
}
