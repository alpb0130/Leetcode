/**
 * Created by alpb0130 on 1/5/16.
 * <p>
 * 88. Merge Sorted Array
 * <p>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold
 * additional elements from nums2. The number of elements initialized in nums1 and nums2 are m
 * and n respectively.
 *
 * Time complexity: O(m + n)
 * Space complexity: O(m)
 */
public class MergeSortedArray {
    // Need extra space but expensive in space
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m];
        System.arraycopy(nums1, 0, nums, 0, m);
        int i = 0, j = 0, index = 0;
        while(index < m + n) {
            if (i == m && j < n) {
                nums1[index] = nums2[j];
                j++;
            } else if (j == n && i < m) {
                nums1[index] = nums[i];
                i++;
            } else {
                if (nums[i] <= nums2[j]) {
                    nums1[index] = nums[i];
                    i++;
                } else {
                    nums1[index] = nums2[j];
                    j++;
                }
                index++;
            }
        }
    }
    // No extra space (three pointer)
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j>= 0) {
            nums1[k--] = nums1[i] >= nums2[j]? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
