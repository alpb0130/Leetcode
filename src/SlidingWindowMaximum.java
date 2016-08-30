import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by alpb0130 on 1/13/16.
 * <p>
 * 239. Sliding Window Maximum
 * <p>
 * Given an array nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one position.
 * <p>
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * <p>
 * Note:
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Follow up:
 * Could you solve it in linear time?
 * <p>
 * Hint:
 * How about using a data structure such as deque (double-ended queue)?
 * The queue size need not be the same as the window’s size.
 * Remove redundant elements and the queue should store only elements that need to be considered.
 */
public class SlidingWindowMaximum {
    // Use max heap. Time complexity: O(n * log k ). Space complexity: O(k).
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Be careful about the array size
        int[] max = new int[nums.length - k + 1];
        // Be careful about the k == 0 condition
        if (nums.length == 0 || k == 0) return new int[0];
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        };
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, c);
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
            // When to remove element from the heap
            if (maxHeap.size() == k) {
                max[i + 1 - k] = maxHeap.peek();
                maxHeap.remove(nums[i - k + 1]);
            }
        }
        return max;
    }

    // Use a deque to store the index of array. Time complexity: O(n). Space complexity: O(k).
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] max = new int[nums.length - k + 1];
        // Be careful about the k == 0 condition
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.offerLast(i);
            if (i > k - 1 && deque.peekFirst() <= i - k) {
                // Poll the first element, not the last!!
                deque.pollFirst();
            }
            if (i >= k - 1)
                max[i - k + 1] = nums[deque.peekFirst()];
        }
        return max;
    }
}
