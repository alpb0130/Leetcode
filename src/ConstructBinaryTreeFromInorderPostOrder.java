import java.util.HashMap;
import java.util.Map;

/**
 * Created by alpb0130 on 1/3/16.
 * <p>
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromInorderPostOrder {
    // Master theorem: T(n) = a * T(n/b) + f(n)
    // T(n) = n^(log_b^a) + f (compare to n^(log_b^a))
    // Here, f(n) = n. T(n) = nlogn.
    // Time complexity: Average - O(n * logn), Best - O(n): right skew, Worst - O(n^2): left skew
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0) return null;
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        TreeNode root = new TreeNode(postorder[postend]);
        if (poststart == postend && instart == inend) return root;
        int in_root = instart;
        while (inorder[in_root] != postorder[postend]) {
            in_root++;
        }
        int left_l = in_root - instart;
        int right_l = inend - in_root;
        if (left_l != 0) {
            TreeNode left = helper(inorder, instart, in_root - 1, postorder, poststart, poststart + left_l - 1);
            root.left = left;
        }
        if (right_l != 0) {
            TreeNode right = helper(inorder, in_root + 1, inend, postorder, postend - right_l, postend - 1);
            root.right = right;
        }
        return root;
    }

    // Improve. Using hashmap to store the index.
    // The time complexity to get the index subtree root is O(1)
    // Master theorem: T(n) = a * T(n/b) + f(n)
    // T(n) = n^(log_b^a) + f (compare to n^(log_b^a))
    // Here, f(n) = 1. T(n) = n.
    Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
        for (int i = 0; i < inorder.length; i++)
            hashmap.put(inorder[i], i);
        return buildHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildHelper(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        TreeNode node = new TreeNode(postorder[postend]);
        if (poststart == postend) return node;
        int rootIndex = hashmap.get(postorder[postend]);
        int leftLen = rootIndex - instart;
        int rightLen = inend - rootIndex;
        if (leftLen != 0)
            node.left = buildHelper(inorder, instart, rootIndex - 1, postorder, poststart, poststart + leftLen - 1);
        if (rightLen != 0)
            node.right = buildHelper(inorder, rootIndex + 1, inend, postorder, postend - rightLen, postend - 1);
        return node;
    }
}
