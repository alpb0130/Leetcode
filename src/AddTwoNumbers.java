/**
 * Created by alpb0130 on 10/7/15.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Digit = l1;
        ListNode l2Digit = l2;
        ListNode result = null;
        ListNode sumDigit = null;
        int carry = 0;
        int sum = 0;
        while (l1Digit != null || l2Digit != null) {
            sum += (l1Digit != null) ? l1Digit.val : 0;
            sum += (l2Digit != null) ? l2Digit.val : 0;
            sum += carry;
            carry = sum / 10;
            if (result == null) {
                result = new ListNode(sum % 10);
                sumDigit = result;
            } else {
                sumDigit.next = new ListNode(sum % 10);
                sumDigit = sumDigit.next;
            }
            sum = 0;
            l1Digit = (l1Digit != null) ? l1Digit.next : null;
            l2Digit = (l2Digit != null) ? l2Digit.next : null;
        }
        if (carry == 1) {
            sumDigit.next = new ListNode(1);
        }
        return result;
//        ListNode sumNode;
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        ListNode l1Digit = l1;
//        ListNode l2Digit = l2;
//        int carry;
//        int sum;
//        sum = l1Digit.val + l2Digit.val;
//        carry = sum / 10;
//        sum = sum % 10;
//        sumNode = new ListNode(sum);
//        sumNode.next = null;
//        ListNode sumDigit = sumNode;
//        l1Digit = l1.next;
//        l2Digit = l2.next;
//        while (l1Digit != null && l2Digit != null) {
//            sum = l1Digit.val + l2Digit.val + carry;
//            carry = sum / 10;
//            sum = sum % 10;
//            sumDigit.next = new ListNode(sum);
//            sumDigit.next.next = null;
//            sumDigit = sumDigit.next;
//            l1Digit = l1Digit.next;
//            l2Digit = l2Digit.next;
//        }
//        while (l1Digit != null) {
//            sum = l1Digit.val + carry;
//            carry = sum / 10;
//            sum = sum % 10;
//            sumDigit.next = new ListNode(sum);
//            sumDigit.next.next = null;
//            sumDigit = sumDigit.next;
//            l1Digit = l1Digit.next;
//        }
//        while (l2Digit != null) {
//            sum = l2Digit.val + carry;
//            carry = sum / 10;
//            sum = sum % 10;
//            sumDigit.next = new ListNode(sum);
//            sumDigit.next.next = null;
//            sumDigit = sumDigit.next;
//            l2Digit = l2Digit.next;
//        }
//        if (carry == 1) {
//            sumDigit.next = new ListNode(carry);
//            sumDigit.next.next = null;
//        }
//        return sumNode;
    }
}
