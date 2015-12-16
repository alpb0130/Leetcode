import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by alpb0130 on 11/11/15.
 * Binary Tree Inorder Traversal
 * <p>
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 *  1
 *   \
 *    2
 *   /
 *  3
 * return [1,3,2].
 * Note:
 * Recursive solution is trivial, could you do it iteratively?
 *
 * Time complexity: O (n)
 *
 */
public class BTInorderTraversal {
    // Iterative style 1
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<Integer>();
        if (root == null) {return nodeList;}
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);
        while (nodeStack.peek().left != null) {
            nodeStack.push(nodeStack.peek().left);
        }
        while(!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            nodeList.add(node.val);
            if (node.right != null) {
                nodeStack.push(node.right);
                while (nodeStack.peek().left != null) {
                    nodeStack.push(nodeStack.peek().left);
                }
            }
        }
        return nodeList;
    }
    // Iterative style 2
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> nodeList = new ArrayList<Integer>();
        if (root == null) {return nodeList;}
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !nodeStack.isEmpty()) {
            if (node != null) {
                nodeStack.push(node);
                node = node.left;
            } else {
                node = nodeStack.pop();
                nodeList.add(node.val);
                node = node.right;
            }
        }
        return nodeList;
    }
    // Recursive style
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> nodeList = new ArrayList<Integer>();
        inOrder(root, nodeList);
        return nodeList;
    }
    public void inOrder(TreeNode root, List<Integer> nodeList) {
        if(root == null) return;
        inOrder(root.left, nodeList);
        nodeList.add(root.val);
        inOrder(root.right, nodeList);
    }
}
