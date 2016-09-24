import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by alpb0130 on 8/30/16.
 * <p>
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [3,2,1].
 */
public class BTPostorderTraversal {
    // Use the idea of preorder traversal
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(0, node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return list;
    }

    // Morris Traverse
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode cur = dummy;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode succ = cur.left;
                while (succ.right != null & succ.right != cur) succ = succ.right;
                if (succ.right == null) {
                    succ.right = cur;
                    cur = cur.left;
                } else {
                    succ.right = null;
                    printReverse(cur.left, succ, list);
                    cur = cur.right;
                }
            } else {
                cur = cur.right;
            }
        }
        return list;
    }

    public void printReverse(TreeNode from, TreeNode to, List<Integer> list) {
        reverse(from, to);
        TreeNode temp = to;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.right;
        }
        reverse(to, from);
    }

    public void reverse(TreeNode from, TreeNode to) {
        TreeNode a = null, b = from, c;
        while (a != to) {
            c = b.right;
            b.right = a;
            a = b;
            b = c;
        }
    }
}
