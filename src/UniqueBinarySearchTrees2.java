/**
 * Created by alpb0130 on 10/30/15.
 * Modified by alpb0130 on 08/31/16
 * <p>
 * Unique Binary Search Trees II
 * <p>
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * <p>
 * 1       3     3       2     1
 * \      /     /       / \    \
 * 3     2     1       1  3    2
 * /    /      \               \
 * 2   1       2               3
 * <p>
 * Time Complexity: O(n^3)
 */

import java.util.List;
import java.util.ArrayList;

public class UniqueBinarySearchTrees2 {
    // DP
    // Store left subtree in array list
    // For right subtree, use the generated left subtree to build with an offset value
    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> dpList = new ArrayList<List<TreeNode>>();
        dpList.add(new ArrayList<TreeNode>());
        if (n == 0) return dpList.get(0);
        dpList.get(0).add(null);
        for (int len = 1; len < n + 1; len++) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            for (int i = 1; i < len + 1; i++) {
                // Pay attention to the index here
                for (TreeNode nodeLeft : dpList.get(i - 1)) {
                    for (TreeNode nodeRight : dpList.get(len - i)) {
                        TreeNode node = new TreeNode(i);
                        node.left = nodeLeft;
                        node.right = cloneTree(nodeRight, i);
                        list.add(node);
                    }
                }
            }
            dpList.add(list);
        }
        return dpList.get(n);
    }

    public TreeNode cloneTree(TreeNode node, int offset) {
        if (node == null) return null;
        TreeNode root = new TreeNode(node.val + offset);
        root.left = cloneTree(node.left, offset);
        root.right = cloneTree(node.right, offset);
        return root;
    }

    // My version: recursive
    public List<TreeNode> generateTrees1(int n) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (n == 0) return list;
        return generateHelper(n, 1);
    }

    // @param n size of tree
    // @param start start index
    public List<TreeNode> generateHelper(int n, int start) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (n == 0) {
            list.add(null);
            return list;
        }
        for (int i = start; i < n + start; i++) {
            // Pay attention to the index here
            List<TreeNode> leftList = generateHelper(i - start, start);
            List<TreeNode> rightList = generateHelper(n + start - i - 1, i + 1);
            for (int w = 0; w < leftList.size(); w++) {
                for (int v = 0; v < rightList.size(); v++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(w);
                    root.right = rightList.get(v);
                    list.add(root);
                }
            }
        }
        return list;
    }
}
