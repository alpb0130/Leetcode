import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by alpb0130 on 9/2/16.
 * <p>
 * 117. Populating Next Right Pointers in Each Node II
 * <p>
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * <p>
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * <p>
 * Note:
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersII {
    // Iterative style. DFS. Much cleaner version.
    // O(1) space.
    public void connect3(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode cur = root;
        TreeLinkNode pre = null, head = null;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (pre != null) {
                        pre.next = cur.left;
                        pre = pre.next;
                    } else {
                        pre = cur.left;
                        head = pre;
                    }
                }
                if (cur.right != null) {
                    if (pre != null) {
                        pre.next = cur.right;
                        pre = pre.next;
                    } else {
                        pre = cur.right;
                        head = pre;
                    }
                }
                cur = cur.next;
            }
            cur = head;
            pre = null;
            head = null;
        }
    }

    // Iterative style. O(1) space.
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode node = root;
        while (node != null) {
            TreeLinkNode cur = null;
            TreeLinkNode temp = node;
            // Find the first non-null node in the next level
            while (temp != null) {
                if (temp.left != null) cur = temp.left;
                if (cur != null) break;
                if (temp.right != null) cur = temp.right;
                if (cur != null) break;
                temp = temp.next;
            }
            temp = node;
            node = cur;
            // Populate
            while (temp != null) {
                if (temp.left != null && temp.left != cur) {
                    cur.next = temp.left;
                    cur = cur.next;
                }
                if (temp.right != null && temp.right != cur) {
                    cur.next = temp.right;
                    cur = cur.next;
                }
                temp = temp.next;
            }
        }
    }

    // Iterative style. Level Order traverse.
    public void connect1(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = queue.poll();
                node.next = (i == size - 1) ? null : queue.peek();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
    }

    // DFS. Iterative. Dummy head.
    // Time complexity: O(n)
    // Space complexity: O(1)
    public void connect2(TreeLinkNode root) {
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode pre = dummyHead;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {
                pre = dummyHead;
                root = dummyHead.next;
                dummyHead.next = null;
            }
        }
    }
}
