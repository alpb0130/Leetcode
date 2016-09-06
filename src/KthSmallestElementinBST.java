import java.util.*;

/**
 * Created by alpb0130 on 12/16/15.
 * <p>
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine? Answer: use a max heap with size k to maintain the k smallest
 * elements in the BST and once a new node come, compare it with top element of the heap.
 * <p>
 * Time complexity: O(k)
 */
public class KthSmallestElementinBST {
    // Iterative inorder traversal.
    // Time complexity: O(n)
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (0 == (--k)) return node.val;
                node = node.right;
            }
        }
        return -1;
    }

    // Divide and conquer
    // Time complexity: O(n)
    public int kthSmallest1(TreeNode root, int k) {
        int num = countHelper(root.left);
        if (num >= k) return kthSmallest1(root.left, k);
        if (num + 1 < k) return kthSmallest1(root.right, k - num - 1);
        return root.val;
    }

    public int countHelper(TreeNode root) {
        if (root == null) return 0;
        return countHelper(root.left) + countHelper(root.right) + 1;
    }
}
