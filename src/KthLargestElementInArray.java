import java.lang.reflect.Array;
import java.net.CookieManager;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by alpb0130 on 1/10/16.
 * <p>
 * 215. Kth Largest Element in an Array
 * <p>
 * Find the kth largest element in an unsorted array. Note that it is the
 * kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * <p>
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */
public class KthLargestElementInArray {
    // Quick select.
    public int findKthLargest4(int[] nums, int k) {
        shuffle(nums);
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    public int quickSelect(int[] nums, int k, int start, int end) {
        int i = start + 1, j = end;
        while (true) {
            while (i <= end && nums[i] >= nums[start]) i++;
            while (j > start && nums[j] <= nums[start]) j--;
            if (i > end || j <= start || j < i) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        if (j == k - 1) return nums[j];
        if (j < k - 1) return quickSelect(nums, k, j + 1, end);
        if (j > k - 1) return quickSelect(nums, k, start, j - 1);
        return nums[k];
    }

    // Sort.
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // Minimum heap (Use priority queue in java). Time complexity: O(nlogk). Space complexity: O(k).
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) queue.poll();
        }
        return queue.poll();
    }

    // Maximum heap. Time complexity: O(n + klogn). Space complexity: O(n).
    public int findKthLargest2(int[] nums, int k) {
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(nums.length, c);
        // (n)
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        // (klogn)
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.poll();
    }

    // Bubble sort. Time complexity: O(nk). Space complexity: O(1). Bad method.
    public int findKthLargest3(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
        return nums[k - 1];
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    void shuffle(int[] nums) {
        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            swap(nums, i, r.nextInt(i + 1));
        }
    }
}
