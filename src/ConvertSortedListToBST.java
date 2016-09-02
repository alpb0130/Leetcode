/**
 * Created by alpb0130 on 9/1/16.
 * <p>
 * 109. Convert Sorted List to Binary Search Tree
 * <p>
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedListToBST {
    // Recursive style and two pointers.
    // Use two pointer to find the mid value of sorted list
    // Time complexity: O(nlogn)
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return buildHelper(head, null);
    }

    public TreeNode buildHelper(ListNode head, ListNode tail) {
        if (head == null || head == tail) return null;
        ListNode oneStep = head, twoStep = head;
        while (twoStep != tail && twoStep.next != tail) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        TreeNode root = new TreeNode(oneStep.val);
        root.left = buildHelper(head, oneStep);
        root.right = buildHelper(oneStep.next, tail);
        return root;
    }

    // Recursive style. Simulate inorder traverse and build the tree.
    // A global pointer to track current node.
    // Time complexity: O(n)
    ListNode node = null;

    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) return null;
        int size = 0;
        ListNode n = head;
        while (n != null) {
            size++;
            n = n.next;
        }
        node = head;
        return buildHelper(0, size - 1);
    }

    public TreeNode buildHelper(int start, int end) {
        if (start > end) return null;
        if (start == end) {
            TreeNode root = new TreeNode(node.val);
            node = node.next;
            return root;
        }
        int mid = (start + end) / 2;
        TreeNode left = buildHelper(start, mid - 1);
        TreeNode root = new TreeNode(node.val);
        root.left = left;
        node = node.next;
        root.right = buildHelper(mid + 1, end);
        return root;
    }
}
