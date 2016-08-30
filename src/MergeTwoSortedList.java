/**
 * Created by alpb0130 on 1/13/16.
 * <p>
 * 21. Merge Two Sorted Lists
 * <p>
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedList {
    // Recursive
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    // Iterative
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node1 = l1, node2 = l2, head = null, current = null;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                if (head == null)
                    head = node1;
                if (current != null)
                    current.next = node1;
                current = node1;
                node1 = node1.next;
            } else {
                if (head == null)
                    head = node2;
                if (current != null)
                    current.next = node2;
                current = node2;
                node2 = node2.next;
            }
        }
        current.next = node1 == null ? node2 : node1;
        return head;
    }
}
