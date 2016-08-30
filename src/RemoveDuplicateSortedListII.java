/**
 * Created by alpb0130 on 2/20/16.
 * <p>
 * 82. Remove Duplicates from Sorted List II
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * <p>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicateSortedListII {
    // Recursive style
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val && head.next.next != null && head.next.val == head.next.next.val) {
            return deleteDuplicates(head.next);
        }
        if ((head.val == head.next.val) && ((head.next.next != null && head.next.val != head.next.next.val) || (head.next.next == null))) {
            return deleteDuplicates(head.next.next);
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }


}
