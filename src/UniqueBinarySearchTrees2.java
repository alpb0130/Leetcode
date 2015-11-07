/**
 * Created by alpb0130 on 10/30/15.
 * <p>
 * Unique Binary Search Trees II
 * <p>
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * Time Complexity: O(n^3)
 */

import java.util.List;
import java.util.ArrayList;

public class UniqueBinarySearchTrees2 {
    // DP
    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> dpList = new ArrayList<List<TreeNode>>();
        ArrayList<TreeNode> dp = new ArrayList<TreeNode>();
        dp.add(null);
        dpList.add(dp);
        dp = new ArrayList<>();
        TreeNode node = new TreeNode(1);
        dp.add(node);
        dpList.add(dp);
        for (int i = 2; i <= n; i++) {
            dp = new ArrayList<TreeNode>();
            for (int j = 1; j <= i; j++) {
                for (int k = 0; k < dpList.get(j - 1).size(); k++) {
                    for (int m = 0; m < dpList.get(i - j).size(); m++) {
                        node = new TreeNode(j);
                        node.left = dpList.get(j - 1).get(k);
                        node.right = addTreeValue(dpList.get(i - j).get(m), j);
                        dp.add(node);
                    }
                }
                dpList.add(dp);
            }
        }

        return dpList.get(n);
    }

    public TreeNode addTreeValue(TreeNode root, int offset) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val + offset);
        node.left = addTreeValue(root.left, offset);
        node.right = addTreeValue(root.right, offset);
        return node;
    }
}
