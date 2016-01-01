import java.util.*;

/**
 * Created by alpb0130 on 1/1/16.
 * <p>
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * For example:
 * Given the following binary tree,
 *          1            <---
 *        /   \
 *       2     3         <---
 *       \     \
 *       5     4       <---
 * You should return [1, 3, 4].
 * <p>
 * Time Complexity: O (n)
 */
public class BinaryTreeRightSideView {
    // Iterative style
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) return list;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                if (size == 0) list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return list;
    }

    // Recursive style
    public List<Integer> rightSideView1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        rightSide(root, 0, list);
        return list;

    }

    public void rightSide(TreeNode root, int level, ArrayList<Integer> list) {
        if (root == null) return;
        if (level == list.size()) list.add(root.val);
        rightSide(root.right, level + 1, list);
        rightSide(root.left, level + 1, list);
    }
}
