import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by alpb0130 on 1/18/16.
 * <p>
 * 234. Palindrome Linked List
 * <p>
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    // Stack and queue. Time complxity: O(n). Space complexity: O(n).
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            queue.offer(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll()))
                return false;
        }
        return true;
    }
    // Find the midpoint and reverse the second half LinkedList. Time complexity: O(n). Space complexity: O(1).
    // But there would be a better way to find the midNode of the List.
    public boolean isPalindrome1(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        int mid = count % 2 == 0 ? (count / 2 + 1) : (count / 2 + 2);
        ListNode start = head;
        node = head;
        count = 0;
        while (node != null) {
            count++;
            if (count == mid) {
                break;
            }
            node = node.next;
        }
        ListNode previous = null;
        while (node != null) {
            ListNode temp = node;
            node = node.next;
            temp.next = previous;
            previous = temp;
        }
        node = previous;
        while (node != null) {
            if (node.val != start.val) return false;
            node = node.next;
            start = start.next;
        }
        return true;
    }
    // Refine the find midnode process in previous method.
    // Time complexity: O(n). Space complexity: O(1).
    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode previous = null;
        while (slow != null) {
            ListNode temp = slow;
            slow = slow.next;
            temp.next = previous;
            previous = temp;
        }
        slow = previous;
        while (slow != null) {
            if (slow.val != head.val) return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
}
