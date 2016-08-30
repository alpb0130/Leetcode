/**
 * Created by alpb0130 on 2/11/16.
 * <p>
 * 19. Remove Nth Node From End of List
 * <p>
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * <p>
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class RemoveNthNodeFromEndofList {
    // One pass. O(n). Take care of the corner case.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode node_1 = head;
        while (n > 0) {
            node_1 = node_1.next;
            n--;
        }
        ListNode node_2 = head;
        if (node_1 == null) {
            head = head.next;
            return head;
        }
        while (node_1.next != null) {
            node_1 = node_1.next;
            node_2 = node_2.next;
        }
        node_2.next = node_2.next.next;
        return head;
    }
}
