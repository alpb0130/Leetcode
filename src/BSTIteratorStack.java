import java.util.Stack;

/**
 * Created by alpb0130 on 9/4/16.
 * <p>
 * Another solution of BST Iterator
 */
public class BSTIteratorStack {
    // Use a stack to simulate the inorder traverse
    // Amortized cost for next is 0(1)
    // One for push, another for pop
    // Space complexity is O(n)
    Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIteratorStack(TreeNode root) {
        pushLeft(root);
    }

    public void pushLeft(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        pushLeft(node.right);
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
