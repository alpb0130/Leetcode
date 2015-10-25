/**
 * Created by alpb0130 on 10/24/15.
 * <p>
 * Binary Tree Paths
 * <p>
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 *      1
 *    /   \
 *   2     3
 *    \
 *    5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * <p>
 * Time Complexity: O (n)
 */

import java.lang.reflect.Array;
import java.util.*;

public class BinaryTreePaths {
    // Recursive style
    public List<String> binaryTreePaths(TreeNode root) {
        String str = new String();
        return TreePaths(root, str);
    }

    public List<String> TreePaths(TreeNode root, String str) {
        List<String> strList = new ArrayList<String>();
        if (root == null) {
            return strList;
        }
        if (root.left == null && root.right == null) {
            str += root.val;
            strList.add(str);
            return strList;
        }
        str += root.val + new String("->");
        strList = TreePaths(root.left, str);
        List<String> strListRight = TreePaths(root.right, str);
        for (int i = 0; i < strListRight.size(); i++)
            strList.add(strListRight.get(i));
        return strList;
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
