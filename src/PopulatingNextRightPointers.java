/**
 * Created by alpb0130 on 11/12/15.
 * Given a binary tree
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level,
 * and every parent has two children).For example,
 * Given the following perfect binary tree,
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 * int val;
 * TreeLinkNode left, right, next;
 * TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointers {
    // Iterative style.
    // Time complexity: O(n). Space complexity: O(1)
    public void connect2(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode node = root;
        TreeLinkNode cur = null;
        // Traverse the leftmost node
        while (node.left != null) {
            cur = node;
            // Traverse node in the same level
            while (cur != null) {
                cur.left.next = cur.right;
                cur.right.next = cur.next != null ? cur.next.left : null;
                cur = cur.next;
            }
            node = node.left;
        }
    }

    // Recursive style.
    // Time complexity: O(n). Space complexity: O(1).
    public void connect3(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode node = root;
        if (root.left != null) {
            while (node != null) {
                node.left.next = node.right;
                node.right.next = node.next != null ? node.next.left : null;
                node = node.next;
            }
        }
        connect(root.left);
    }

    // Iterative style. BFS.
    // Space complexity: O(n)
    // Time complexity: O(n)
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> nodeQueue = new LinkedList<TreeLinkNode>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            while (size > 0) {
                TreeLinkNode node = nodeQueue.poll();
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                }
                size--;
                if (size > 0) {
                    node.next = nodeQueue.peek();
                } else {
                    node.next = null;
                }
            }
        }
    }

    // Recursive style. DFS.
    // Time complexity: O(n^log_2^3)
    // Space complexity: Not O(1)
    public void connect1(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        root.next = null;
        connectNode(root.left, root.right);
    }

    public void connectNode(TreeLinkNode left, TreeLinkNode right) {
        if (left == null || right == null) return;
        left.next = right;
        connectNode(left.left, left.right);
        connectNode(left.right, right.left);
        connectNode(right.left, right.right);

    }
}
