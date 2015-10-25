/**
 * Created by alpb0130 on 10/24/15.
 * <p>
 * Tree
 */

import java.util.*;

public class Tree {
    TreeNode root;

    public void initialize(int[] node) {
        if (node.length == 0) {
            return;
        }
        int i = 0;
        root = new TreeNode();
        root.val = node[i];
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        i++;
        while (i < node.length && !nodeQueue.isEmpty()) {
            TreeNode temp = nodeQueue.poll();
            if (node[i] >= 0) {
                temp.left = new TreeNode(node[i]);
                nodeQueue.offer(temp.left);
            }
            i++;
            if (i >= node.length) break;
            if (node[i] >= 0) {
                temp.right = new TreeNode(node[i]);
                nodeQueue.offer(temp.right);
            }
            i++;
        }
    }
}
