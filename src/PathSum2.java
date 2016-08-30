/**
 * Created by alpb0130 on 9/24/15.
 */

import java.util.*;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> pathList = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        getPathList(root, sum, pathList, list);
        return pathList;
    }

    public void getPathList(TreeNode root, int sum, ArrayList<List<Integer>> pathList, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            list.add(root.val);
            pathList.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
            return;
        }
        if (root.left != null) {
            list.add(root.val);
            getPathList(root.left, sum - root.val, pathList, list);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.val);
            getPathList(root.right, sum - root.val, pathList, list);
            list.remove(list.size() - 1);
        }
        return;
    }
}
