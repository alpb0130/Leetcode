/**
 * Created by alpb0130 on 10/7/15.
 * Modified by alpb0130 on 09/11/2016
 * <p>
 * 2. Add Two Numbers
 * <p>
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain
 * a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    // Dummy node.
    // Time: O(n + m)
    // Space: O(1)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode ptr = dummy;
        int carry = 0;
        int sum = 0;
        while (ptr1 != null || ptr2 != null || carry != 0) {
            sum = 0;
            sum += carry;
            if (ptr1 != null) {
                sum += ptr1.val;
                ptr1 = ptr1.next;
            }
            if (ptr2 != null) {
                sum += ptr2.val;
                ptr2 = ptr2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }
        return dummy.next;
    }
}
