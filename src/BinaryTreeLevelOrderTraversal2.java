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
}
