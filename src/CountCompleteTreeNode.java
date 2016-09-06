import java.util.Stack;

/**
 * Created by alpb0130 on 1/1/16.
 * <p>
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last,
 * is completely filled, and all nodes in the last level are as far
 * left as possible. It can have between 1 and 2^h nodes inclusive at
 * the last level h.
 * <p>
 * 2nd-Time Complexity: O(h + h^2)
 */
public class CountCompleteTreeNode {
    // Recursive style, divide and conquer.
    // Compute and number of node for complete tree directly.
    // I think the time complexity is O(h^2)
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int l = depthofLeft(root.left);
        int r = depthofRight(root.right);
        if (l == r) {
            return (2 << l) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int depthofLeft(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    public int depthofRight(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.right;
        }
        return depth;
    }

    // Count height first and then count node for last level (divide and conquer)
    public int countNodes1(TreeNode root) {
        if (root == null) return 0;
        // Get the height
        TreeNode node = root;
        int height = 0;
        while (node.left != null) {
            height++;
            node = node.left;
        }
        return ((1 << height) - 1) + lastLevelCount(root, height);
    }

    public int lastLevelCount(TreeNode root, int height) {
        if (root == null) return 0;
        if (height == 0) return 1;
        TreeNode midNode = root.left;
        int curH = 1;
        while (curH < height) {
            midNode = midNode.right;
            curH++;
        }
        if (midNode == null) return lastLevelCount(root.left, height - 1);
        else return (1 << (height - 1)) + lastLevelCount(root.right, height - 1);
    }
}
