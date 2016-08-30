/**
 * Created by alpb0130 on 10/23/15.
 * <p>
 * Binary Tree Level Order Traversal
 * <p>
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example: Given binary tree {3,9,20,#,#,15,7},
 *      3
 *     / \
 *    9  20
 *      /  \
 *    15   7
 * return its level order traversal as:
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 *
 * Time Complexity O(n)
 * Space Complexity O(k * n)
 */

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> llist = new ArrayList<List<Integer>>();
        if (root == null) return llist;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<Integer>();
            int size = queue.size();
            while (size > 0) {
                TreeNode tempNode = queue.poll();
                tempList.add(tempNode.val);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
                size--;
            }
            llist.add(tempList);
        }
        return llist;
    }
}
