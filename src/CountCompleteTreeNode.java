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
 *
 * 2nd-Time Complexity: O(h + h^2)
 */
public class CountCompleteTreeNode {
    // Recursive style, divide and conquer
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

    // Count height first and then count node for last level
    public int countNodes1(TreeNode root) {
        if (root==null) return 0;
        if (root.left==null) return 1;
        int height = 0;
        int nodesSum = 0;
        TreeNode curr = root;
        while(curr.left!=null) {
            nodesSum += (1<<height);
            height++;
            curr = curr.left;
        }
        return nodesSum + countLastLevel(root, height);
    }

    private int countLastLevel(TreeNode root, int height) {
        if(height==1)
            if (root.right!=null) return 2;
            else if (root.left!=null) return 1;
            else return 0;
        TreeNode midNode = root.left;
        int currHeight = 1;
        while(currHeight<height) {
            currHeight++;
            midNode = midNode.right;
        }
        if (midNode==null) return countLastLevel(root.left, height-1);
        else return (1<<(height-1)) + countLastLevel(root.right, height-1);
    }
}
