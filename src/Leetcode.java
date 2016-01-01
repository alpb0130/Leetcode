import java.util.List;

/**
 * Created by alpb0130 on 9/24/15.
 */
public class Leetcode {
    public static void main(String[] args) {
        //Tree tree = new Tree();
        //tree.initialize(A);
        //System.out.println(LCAofBT.lowestCommonAncestor(tree.root, new TreeNode(38), new TreeNode(39)).val);
        String str = new String("fd fds    wf");
        String[] strArray = str.split("\\s+");
        System.out.println("length:" + strArray.length);
        for (int i = 0; i < strArray.length; i++) {
            System.out.println("content:" + strArray[i]);
        }
        System.out.println(str.trim());

    }
}