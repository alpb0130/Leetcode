import java.util.*;

/**
 * Created by alpb0130 on 10/23/15.
 * <p>
 * Binary Tree Level Order Traversal II
 * <p>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p>
 * Time Complexity: O (n + l)
 * Space Complexity: O (k * n)
 *
 */
public class BinaryTreeLevelOrderTraversal2 {
    // BFS and stack
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> nodeList = new ArrayList<List<Integer>>();
        Stack<List<Integer>> listStack = new Stack<List<Integer>>();
        if (root == null) {
            return nodeList;
        }
        ArrayList<Integer> nodes;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            nodes = new ArrayList<Integer>();
            while (size != 0) {
                TreeNode node = queue.poll();
                nodes.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            listStack.add(nodes);
        }
        while (!listStack.isEmpty()) {
            nodeList.add(listStack.pop());
        }
        return nodeList;
    }

    // BFS without stack
    // Time complexity: O(n)
    // Space complexity: O(w)
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> llist = new ArrayList<List<Integer>>();
        if (root == null) return llist;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tempList = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tempList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            // Insert new list to the head of list
            llist.add(0, tempList);
        }
        return llist;
    }

    // Recursive
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> llist = new ArrayList<List<Integer>>();
        levelHelper(root, llist, 0);
        return llist;
    }

    public void levelHelper(TreeNode node, List<List<Integer>> llist, int level) {
        if (node == null) return;
        if (level == llist.size()) {
            llist.add(0, new ArrayList<Integer>());
        }
        // Pay attention to which subarray to add new value
        llist.get(llist.size() - level - 1).add(node.val);
        levelHelper(node.left, llist, level + 1);
        levelHelper(node.right, llist, level + 1);
    }
}
