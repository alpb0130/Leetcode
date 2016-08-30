/**
 * Created by alpb0130 on 1/8/16.
 * <p>
 * 141. Linked List Cycle
 * <p>
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 * <p>
 * Time complexity: O(n) and O(n) and O(n)
 * Space complexity: O(1) and O(1) and O(1)
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class LinkedListCycle {
    // After cope with each node, set its next pointer to itself.
    // Then just chech whether the next pointer is pointing to itself.
    public boolean hasCycle(ListNode head) {
        ListNode node = head;
        while (node != null) {
            if (node.next == node) return true;
            ListNode temp = node;
            node = node.next;
            temp.next = temp;

        }
        return false;
    }

    // Two pointers. One is fast and the other is slow. Chase game...
    public boolean hasCycle1(ListNode head) {
        if (head == null) return false;
        ListNode first = head;
        ListNode second = head.next;
        while (first != null && second != null) {
            if (first == second) return true;
            first = first.next;
            if (second.next != null) {
                second = second.next.next;
            } else
                return false;

        }
        return false;
    }

    // Reverse the linked list.
    // If the head is equal to the head after reverse, it has a circle.
    // else no circle exists.
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode node = reverseList(head);
        if (node == head)
            return true;
        return false;
    }

    // Reverse Linked List
    public ListNode reverseList(ListNode head) {
        if (head.next == head) return head;
        ListNode prev = null, node = head;
        while (node.next != null) {
            ListNode temp = node;
            node = node.next;
            temp.next = prev;
            prev = temp;
        }
        return node;
    }
}
