import java.util.ArrayList;

/**
 * Created by alpb0130 on 12/15/15.
 * <p>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w
 * as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 *              _______3______
 *             /              \
 *         ___5__          ___1__
 *        /      \        /      \
 *       6      _2       0       8
 *             /  \
 *            7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5,
 * since a node can be a descendant of itself according to the LCA definition.
 */
public class LCAofBT {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> list2 = new ArrayList<TreeNode>();
        findPath(root, p, list1);
        findPath(root, q, list2);
        int len1 = list1.size();
        int len2 = list2.size();
        int len = Math.min(len1, len2);
        for (int i = 0; i < len; i++) {
            if ((i + 1) >= len ||
                    list1.get(i + 1) != list2.get(i + 1)) {
                return list1.get(i);
            }
        }
        return null;
    }

    public static boolean findPath(TreeNode root, TreeNode target, ArrayList<TreeNode> list) {
        if (root == null) {
            return false;
        }
        System.out.println(root.val);
        list.add(root);
        if (root.val == target.val) return true;
        if (!findPath(root.left, target, list) && !findPath(root.right, target, list)) {
            list.remove(list.size() - 1);
            return false;
        }
        return true;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}
