/**
 * Created by alpb0130 on 11/12/15.
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it
 * can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed
 * later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be
 * serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * For example, you may serialize the following tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily
 * need to follow this format, so please be creative and come up with different approaches yourself.
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms
 * should be stateless.
 */

import com.sun.tools.javac.util.ListBuffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuffer serial = new StringBuffer();
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        serial.append(root.val + " ");
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            while (size > 0) {
                TreeNode node = nodeQueue.poll();
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    serial.append(new Integer(node.left.val) + " ");
                } else {
                    serial.append("# ");
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    serial.append(new Integer(node.right.val) + " ");
                } else {
                    serial.append("# ");
                }
                size--;
            }
        }
        return serial.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;
        String[] nodeStr = data.split(" ");
        int i = 1;
        TreeNode root = new TreeNode(Integer.parseInt(nodeStr[0]));
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            while (size > 0) {
                TreeNode node = nodeQueue.poll();
                if (nodeStr[i].equals("#")) {
                    node.left = null;
                    i++;
                } else {
                    node.left = new TreeNode(Integer.parseInt(nodeStr[i]));
                    nodeQueue.offer(node.left);
                    i++;
                }
                if (nodeStr[i].equals("#")) {
                    node.right = null;
                    i++;
                } else {
                    node.right = new TreeNode(Integer.parseInt(nodeStr[i]));
                    nodeQueue.offer(node.right);
                    i++;
                }
                size--;
            }
        }
        return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));