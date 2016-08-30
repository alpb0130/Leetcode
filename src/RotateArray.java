/**
 * Created by alpb0130 on 1/3/16.
 *
 * 189. Rotate Array
 *
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) or O(1) if inplace
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        if (l <= 1 || k == 0 || l == k) return;
        int[] tempNums = new int[l];
        for(int i = 0; i < l; i++) {
            tempNums[(i + k) % l] = nums[i];
        }
        for(int i = 0; i < l; i++) {
            nums[i] = tempNums[i];
        }
    }
    // Attention: if k > nums.length
    // An efficient method
    public void rotate1(int[] nums, int k) {
        int l = nums.length;
        if (l <= 1 || k == 0 || l == k) return;
        int[] tempNums = new int[l];
        k = k % l;
        System.arraycopy(nums, l - k, tempNums, 0, k);
        System.arraycopy(nums, 0, tempNums, k, l - k);
        System.arraycopy(tempNums, 0, nums, 0, l);
    }
    // Based on reverse. Inplace.
    public void rotate2(int[] nums, int k) {
        int l = nums.length;
        if (l <= 1 || k == 0 || l == k) return;
        k = k % l;
        reverse(nums, 0, l - k - 1);
        reverse(nums, l - k, l - 1);
        reverse(nums, 0, l - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    // Inplace and no reverse (copy...)
    public void rotate3(int[] nums, int k) {
        if (nums.length == 0 || k % nums.length == 0) return;
        int start = 0, i = start, curNum = nums[i], count = 0;
        while (count < nums.length) {
            i = (i + k) % nums.length;
            int tmp = nums[i];
            nums[i] = curNum;
            if (i == start) {
                start++;
                i = start;
                curNum = nums[i];
            } else
                curNum = tmp;
            count++;
        }
    }
}
