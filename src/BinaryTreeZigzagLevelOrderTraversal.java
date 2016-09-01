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
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(2^h)
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    // Recursive style
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        zigzagHelper(root, res, 0);
        return res;
    }

    public void zigzagHelper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (level == res.size()) res.add(new ArrayList<Integer>());
        if (level % 2 == 0) {
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0, root.val);
        }
        zigzagHelper(root.left, res, level + 1);
        zigzagHelper(root.right, res, level + 1);
    }

    // Iterative style
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean isZig = true;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isZig) list.add(node.val);
                else list.add(0, node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(list);
            isZig = !isZig;
        }
        return res;
    }
}
