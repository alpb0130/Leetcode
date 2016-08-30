/**
 * Created by alpb0130 on 1/9/16.
 *
 * 142. Linked List Cycle II
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Note: Do not modify the linked list.
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class LinkedListCycleII {
    // Time Limit Exceeded????
    public ListNode detectCycle(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.println(node.val);
            if (node.next == node) return node;
            ListNode temp = node;
            node = node.next;
            temp.next = temp;

        }
        return null;
    }
    // Two pointers. One is fast and the other is slow. Chase game...
    // The trick lies on how to identify the beginning of the circle
    public ListNode detectCycle1(ListNode head) {
        if (head == null) return null;
        ListNode first = head;
        ListNode second = head;
        while (second != null) {
            first = first.next;
            if (second.next != null) {
                second = second.next.next;
            } else
                return null;
            if (first == second) break;

        }
        if (second == null) return null;
        second = head;
        while (second != first) {
            second = second.next;
            first = first.next;
        }
        return first;
    }
    // Other's solution!
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
