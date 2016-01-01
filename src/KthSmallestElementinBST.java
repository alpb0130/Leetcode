import java.util.*;
/**
 * Created by alpb0130 on 12/16/15.
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine? Answer: use a max heap with size k to maintain the k smallest
 * elements in the BST and once a new node come, compare it with top element of the heap.
 *
 * Time complexity: O(k)
 *
 */
public class KthSmallestElementinBST {
    public int kthSmallest(TreeNode root, int k) {;
        int i = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                i++;
                if (i == k) {
                    return node.val;
                }
                node = node.right;
            }
        }
        return node.val;
    }
}
