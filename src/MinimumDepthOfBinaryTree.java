import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.*;

/**
 * Created by alpb0130 on 10/23/15.
 * <p>
 * Minimum Depth of Binary Tree
 * <p>
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Time Complexity: O (n)
 * <p>
 * Level traverse is better.
 * Time Complexity: O (log n)
 */

public class MinimumDepthOfBinaryTree {
    // DFS
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }

    // BFS
    public int minDepth1(TreeNode root) {
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
                if (node.left == null && node.right == null) {
                    return depth;
                }
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
