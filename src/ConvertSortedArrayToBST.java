import java.util.Stack;

/**
 * Created by alpb0130 on 1/2/16.
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArrayToBST {
    // Iterative style
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> startStack = new Stack<Integer>();
        Stack<Integer> endStack = new Stack<Integer>();
        TreeNode root = new TreeNode(nums[(nums.length - 1) / 2]);
        nodeStack.add(root);
        startStack.add(0);
        endStack.add(nums.length - 1);
        while (!startStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            Integer start = startStack.pop();
            Integer end = endStack.pop();
            Integer mid = (start + end) / 2;
            if (mid - 1 >= start) {
                node.left = new TreeNode(nums[(start + mid - 1) / 2]);
                nodeStack.push(node.left);
                startStack.push(start);
                endStack.push(mid - 1);
            }
            if (mid + 1 <= end) {
                node.right = new TreeNode(nums[(end + mid + 1) / 2]);
                nodeStack.push(node.right);
                startStack.push(mid + 1);
                endStack.push(end);
            }
        }
        return root;
    }

    // Recursive style
    public TreeNode sortedArrayToBST1(int[] nums) {
        if (nums.length == 0) return null;
        return buildBST(nums, 0, nums.length - 1);
    }

    public TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1, end);
        return root;
    }
}
