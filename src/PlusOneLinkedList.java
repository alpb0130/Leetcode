import java.util.LinkedHashMap;

/**
 * Created by alpb0130 on 9/16/16.
 * <p>
 * 369. Plus One Linked List
 * Given a non-negative number represented as a singly
 * linked list of digits, plus one to the number.
 * <p>
 * The digits are stored such that the most significant
 * digit is at the head of the list.
 * <p>
 * Example:
 * Input:
 * 1->2->3
 * <p>
 * Output:
 * 1->2->4
 */
public class PlusOneLinkedList {
    // Recursive
    public ListNode plusOne(ListNode head) {
        if (head == null) return head;
        if (plusHelper(head) == 0) return head;
        else {
            ListNode ret = new ListNode(1);
            ret.next = head;
            return ret;
        }
    }

    public int plusHelper(ListNode head) {
        if (head == null) return 1;
        if (plusHelper(head.next) == 0) return 0;
        int sum = head.val + 1;
        head.val = sum % 10;
        return sum / 10;
    }

    // Iterative.
    // Time: O(n)
    // Space: O(1)
    public ListNode plusOne1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }
        // i = index of last non-9 digit
        i.val++;
        i = i.next;
        while (i != null) {
            i.val = 0;
            i = i.next;
        }
        if (dummy.val == 0) return dummy.next;
        return dummy;
    }
}
