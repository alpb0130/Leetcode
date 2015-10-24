import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by alpb0130 on 10/23/15.
 * Maximum Depth of Binary Tree
 * <p>
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Time Complexity: O (n)
 */
public class MaximumDepthOfBinaryTree {
    // DFS
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    // BFS
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        int depth = 0;
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            depth++;
            while (size != 0) {
                TreeNode node = nodeQueue.poll();
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                }
                size--;
            }
        }
        return depth;
    }
}
