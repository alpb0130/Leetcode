import java.util.ArrayList;
import java.util.List;

/**
 * Created by alpb0130 on 1/4/16.
 *
 * 118. Pascal's Triangle
 *
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class PascalsTriangel {
    // Iterative style
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> llist = new ArrayList<List<Integer>>();
        if (numRows == 0) return llist;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        llist.add(list);
        for (int i = 1; i < numRows; i++) {
            list = new ArrayList<Integer>();
            List<Integer> tempList = llist.get(i - 1);
            for (int j = 0; j < i + 1; j++) {
                int a = j - 1 >= 0 ? tempList.get(j - 1) : 0;
                int b = j < tempList.size() ? tempList.get(j) : 0;
                list.add(a + b);
            }
            llist.add(list);
        }
        return llist;
    }
}
