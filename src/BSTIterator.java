/**
 * Created by alpb0130 on 11/11/15.
 *
 * Binary Search Tree Iterator
 *
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 *
 * Note:
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 * My method visits each node twice. If using stack, each node can only be visited once. But the total run time is long.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    List<TreeNode> nodeList = new ArrayList<TreeNode>();
    int currentIdx;
    public BSTIterator(TreeNode root) {
        initialize(root, nodeList);
        currentIdx = 0;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return currentIdx < nodeList.size();
    }

    /** @return the next smallest number */
    public int next() {
        currentIdx++;
        return nodeList.get(currentIdx-1).val;
    }

    /** Initialize TreeNode List */
    public void initialize(TreeNode root,  List<TreeNode> nodeList) {
        if (root == null) return;
        initialize(root.left, nodeList);
        nodeList.add(root);
        initialize(root.right, nodeList);

    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
