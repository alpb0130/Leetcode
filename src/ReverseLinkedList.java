/**
 * Created by alpb0130 on 1/18/16.
 * <p>
 * 206. Reverse Linked List
 * <p>
 * Reverse a singly linked list.
 * click to show more hints.
 * <p>
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    // Iteratively
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = previous;
            previous = node;
        }
        return previous;
    }

    // Recursively
    public ListNode reverseList1(ListNode head) {
        if (head == null) return head;
        return reverse(null, head);
    }

    public ListNode reverse(ListNode previous, ListNode node) {
        if (node.next == null) {
            node.next = previous;
            return node;
        }
        ListNode next = node.next;
        node.next = previous;
        return reverse(node, next);
    }
}
