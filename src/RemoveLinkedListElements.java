/**
 * Created by alpb0130 on 2/20/16.
 * <p>
 * 203. Remove Linked List Elements
 * <p>
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {
    // Iterative style. Time complexity: O(n)
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    // Recursive style. Time complexity: O(n)
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return head;
        } else if (head.val == val) {
            return removeElements(head.next, val);
        }
        head.next = removeElements(head.next, val);
        return head;
    }
}
