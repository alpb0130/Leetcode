import java.util.*;

/**
 * Created by alpb0130 on 1/3/16.
 * <p>
 * 103. Binary Tree Zigzag Level Order Traversal
 * <p>
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *      3
 *     / \
 *    9  20
 *      /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(2^h)
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    // Iterative style
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lList = new ArrayList<List<Integer>>();
        if (root == null) return lList;
        Queue<TreeNode> levelQueue = new LinkedList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        levelQueue.offer(root);
        boolean isZigzag = false;
        while (!levelQueue.isEmpty()) {
            int size = levelQueue.size();
            List<Integer> list = new ArrayList<Integer>();
            while (size > 0) {
                TreeNode node = levelQueue.poll();
                if (!isZigzag) {
                    list.add(node.val);
                    if (node.left != null) levelQueue.offer(node.left);
                    if (node.right != null) levelQueue.offer(node.right);
                    size--;
                } else {
                    stack.push(node);
                    if (node.left != null) levelQueue.offer(node.left);
                    if (node.right != null) levelQueue.offer(node.right);
                    size--;
                }
            }
            if (isZigzag) {
                while (!stack.isEmpty()) {
                    list.add(stack.pop().val);
                }
            }
            lList.add(list);
            isZigzag = !isZigzag;
        }
        return lList;
    }
    // Less space
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> lList = new ArrayList<List<Integer>>();
        if (root == null) return lList;
        Queue<TreeNode> levelQueue = new LinkedList<TreeNode>();
        levelQueue.offer(root);
        boolean isZigzag = false;
        while (!levelQueue.isEmpty()) {
            int size = levelQueue.size();
            List<Integer> list = new ArrayList<Integer>();
            while (size > 0) {
                TreeNode node = levelQueue.poll();
                if (!isZigzag) {
                    list.add(node.val);
                    if (node.left != null) levelQueue.offer(node.left);
                    if (node.right != null) levelQueue.offer(node.right);
                    size--;
                } else {
                    list.add(0, node.val);
                    if (node.left != null) levelQueue.offer(node.left);
                    if (node.right != null) levelQueue.offer(node.right);
                    size--;
                }
            }
            lList.add(list);
            isZigzag = !isZigzag;
        }
        return lList;
    }
}
