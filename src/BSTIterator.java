/**
 * Created by alpb0130 on 11/11/15.
 * <p>
 * Binary Search Tree Iterator
 * <p>
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * Note:
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * <p>
 * My method visits each node twice. If using stack, each node can only be visited once. But the total run time is long.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    // Use a list to store all elements.
    // Time complexity: O(n)
    // Space complexity: O(1)
    int index = 0;
    List<Integer> list = new ArrayList<Integer>();

    public BSTIterator(TreeNode root) {
        buildHelper(root);
    }

    public void buildHelper(TreeNode root) {
        if (root == null) return;
        buildHelper(root.left);
        list.add(root.val);
        buildHelper(root.right);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return index < list.size();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return list.get(index++);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
