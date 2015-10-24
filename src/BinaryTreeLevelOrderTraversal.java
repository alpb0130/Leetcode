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
        ArrayList<List<Integer>> nodeList = new ArrayList<List<Integer>>();
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> levelQueue = new LinkedList<Integer>();
        if (root == null) {
            return nodeList;
        }
        Integer level = 1;
        queue.offer(root);
        levelQueue.offer(level);
        while (!queue.isEmpty() && !levelQueue.isEmpty()) {
            TreeNode node = queue.poll();
            level = levelQueue.poll();
            nodes.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                levelQueue.offer(level + 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                levelQueue.offer(level + 1);
            }
            if (level != levelQueue.peek()) {
                nodeList.add(nodes);
                nodes = new ArrayList<Integer>();
            }
        }
        return nodeList;
    }
}
