/**
 * Created by alpb0130 on 9/24/15.
 */

import java.util.*;

public class PathSum2 {
    // Recursive style and back tracking
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        pathHelper(root, sum, res, new ArrayList<Integer>());
        return res;
    }

    public void pathHelper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
        if (root == null) return;
        // Add current node value to the list
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList(list));
            list.remove(list.size() - 1);
            return;
        }
        pathHelper(root.left, sum - root.val, res, list);
        pathHelper(root.right, sum - root.val, res, list);

        // Remove current node from list
        list.remove(list.size() - 1);

        return;
    }
}
