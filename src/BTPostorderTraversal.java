import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by alpb0130 on 8/30/16.
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *  1
 *  \
 *  2
 *  /
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
}
