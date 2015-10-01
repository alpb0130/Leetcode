import apple.laf.JRSUIUtils;

/**
 * Created by alpb0130 on 9/24/15.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){}

    TreeNode(int x) {
        val = x;
        left =null;
        right = null;
    }
    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
    void addLeftCld(TreeNode left) {
        this.left = left;
    }
    void  addRightCld(TreeNode right) {
        this.right = right;
    }
}

