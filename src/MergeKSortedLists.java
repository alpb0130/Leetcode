import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
/**
 * Created by alpb0130 on 1/13/16.
 * <p>
 * 23. Merge k Sorted Lists
 * <p>
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class MergeKSortedLists {
    // Use min heap (priority queue). Time complexity: O(n * logk). Space complexity: O(1).
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        if (lists.length == 0) return null;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                queue.offer(lists[i]);
        }
        ListNode head = null;
        ListNode current = null;
        while (!queue.isEmpty()) {
            if (head == null) head = queue.peek();
            if (current != null)
                current.next = queue.peek();
            current = queue.poll();
            if (current.next != null)
                queue.offer(current.next);

        }
        return head;
    }

    // Based on merge two list and partition.
    // Time complexity: O(log k * n). Space complexity: O(1).
    public static ListNode mergeKLists1(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    public static ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start < end) {
            int mid = (start + end) / 2;
            ListNode node1 = partition(lists, start, mid);
            ListNode node2 = partition(lists, mid + 1, end);
            return merge(node1, node2);
        } else {
            return null;
        }
    }

    public static ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        if (node1.val < node2.val) {
            node1.next = merge(node1.next, node2);
            return node1;
        } else {
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }
}
