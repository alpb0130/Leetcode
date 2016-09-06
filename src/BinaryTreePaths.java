/**
 * Created by alpb0130 on 10/24/15.
 * <p>
 * Binary Tree Paths
 * <p>
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * <p>
 * Time Complexity: O (n)
 */

import java.lang.reflect.Array;
import java.util.*;

public class BinaryTreePaths {
    // Recursive style with helper (Pretty like PathSumII)
    // Time complexity: O(n)
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        pathHelper(root, res, new String());
        return res;
    }

    public void pathHelper(TreeNode root, List<String> res, String str) {
        if (root == null) return;
        if (root.left == null && root.right == null) res.add(str + root.val);
        pathHelper(root.left, res, str + root.val + "->");
        pathHelper(root.right, res, str + root.val + "->");
    }

    // Recursive style without helper function
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> paths = new LinkedList<>();
        if (root == null) return paths;
        if (root.left == null && root.right == null) {
            paths.add(root.val + "");
            return paths;
        }
        for (String path : binaryTreePaths(root.left)) {
            paths.add(root.val + "->" + path);
        }
        for (String path : binaryTreePaths(root.right)) {
            paths.add(root.val + "->" + path);
        }

        return paths;
    }

    // Iterative style
    public static List<String> binaryTreePaths1(TreeNode root) {
        List<String> strList = new ArrayList<String>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<String> stringStack = new Stack<String>();
        if (root == null) {
            return strList;
        }
        nodeStack.push(root);
        String str = new String("");
        stringStack.push(str);
        String temp;
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            temp = stringStack.pop();
            if (node.left == null && node.right == null) {
                temp += node.val;
                strList.add(temp);
            } else {
                temp += node.val + new String("->");
                if (node.right != null) {
                    nodeStack.push(node.right);
                    stringStack.push(temp);
                }
                if (node.left != null) {
                    nodeStack.push(node.left);
                    stringStack.push(temp);
                }
            }
        }
        return strList;
    }
}
