/**
 * Created by alpb0130 on 2/11/16.
 * <p>
 * 160. Intersection of Two Linked Lists
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * A:          a1 → a2
 *                     ↘
 *                       c1 → c2 → c3
 *                     ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * <p>
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionofTwoLinkedList {
    // Traverse the linked list and switch after meed the end. Time complexity: O(n + m). Space complexity: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode node_1 = headA;
        ListNode node_2 = headB;
        while (node_1 != node_2) {
            node_1 = node_1 == null ? headB : node_1.next;
            node_2 = node_2 == null ? headA : node_2.next;
        }
        return node_1;
    }
}
