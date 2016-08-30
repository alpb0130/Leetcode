/**
 * Created by alpb0130 on 1/9/16.
 * <p>
 * 237. Delete Node in a Linked List
 * <p>
 * Write a function to delete a node (except the tail)
 * in a singly linked list, given only access to that node.
 * <p>
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are
 * given the third node with value 3, the linked list should
 * become 1 -> 2 -> 4 after calling your function.
 * <p>
 * Time complexity: O(n) and O(1)
 * Space complexity: O(1) and O(1)
 */
public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        while (next.next != null) {
            node.val = next.val;
            node = next;
            next = next.next;
        }
        node.val = next.val;
        node.next = null;
        return;
    }

    // O(1)
    public void deleteNode1(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
