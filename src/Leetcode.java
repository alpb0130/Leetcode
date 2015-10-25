import java.util.List;

/**
 * Created by alpb0130 on 9/24/15.
 */
public class Leetcode {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        Tree tree = new Tree();
        tree.initialize(A);
        System.out.println(BinaryTreePaths.binaryTreePaths1(tree.root));
    }
}