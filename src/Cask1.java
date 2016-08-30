import java.util.ArrayList;
import java.util.List;

/**
 * Created by alpb0130 on 2/2/16.
 *
 * Reture the path with maximum sum
 */
public class Cask1 {
    public int getPath(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        int left_sum = getPath(root.left);
        int right_sum = getPath(root.right);
        int sum = root.val;
        sum += left_sum > right_sum? left_sum : right_sum;
        return  sum;

    }
}
