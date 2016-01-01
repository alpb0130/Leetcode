import java.util.*;
/**
 * Created by alpb0130 on 12/16/15.
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BTPreorderTraversal {
    // Recursive style
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        traversal(root, list);
        return list;
    }
    public void traversal(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, list);
    }
    // Iterative style
    public List<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }
}
