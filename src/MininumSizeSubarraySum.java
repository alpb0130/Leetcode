import java.util.Arrays;

/**
 * Created by alpb0130 on 1/7/16.
 * <p>
 * 209. Minimum Size Subarray Sum
 * <p>
 * Given an array of n positive integers and a positive integer s, find the minimal length of a
 * subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 * <p>
 * Space complexity: O(1)
 */
public class MininumSizeSubarraySum {
    // O(nlogn).Binary search if a window of size k exists that satisfy the condition.
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0 || s == 0) return 0;
        int ret = 0;
        int i = 0, j = nums.length;
        while (true) {
            if (i > j) break;
            int mid = (i + j) / 2;
            if (existSize(mid, nums, s)) {
                j = mid - 1;
                ret = mid;
            } else
                i = mid + 1;
        }
        return ret;
    }

    public boolean existSize(int size, int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= size) {
                sum -= nums[i - size];
            }
            sum += nums[i];
            if (sum >= s) return true;
        }
        return false;
    }

    // O(n). Sliding window.
    public int minSubArrayLen1(int s, int[] nums) {
        if (nums.length == 0 || s == 0) return 0;
        int l = nums.length;
        int start = 0, end = 0;
        int sum = 0;
        int ret = Integer.MAX_VALUE;
        while (true) {
            if (sum >= s && start < l) {
                ret = end - start < ret ? end - start : ret;
                sum -= nums[start];
                start++;
            } else if (end < l) {
                sum += nums[end];
                end++;
            } else
                break;
        }
        return ret == Integer.MAX_VALUE ? 0 : ret;
    }

    //O(N) - keep a moving window expand until sum>=s, then shrink util sum<s.
    // Each time after shrinking, update length. (similar to other solutions,
    // just removed unnecessary min value assignment)
    public int minSubArrayLen2(int s, int[] nums) {
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (j < nums.length) {
            while (sum < s && j < nums.length) sum += nums[j++];
            if (sum >= s) {
                while (sum >= s && i < j) sum -= nums[i++];
                min = Math.min(min, j - i + 1);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
