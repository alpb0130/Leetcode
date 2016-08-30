import java.util.ArrayList;
import java.util.List;

/**
 * Created by alpb0130 on 1/5/16.
 * <p>
 * 119. Pascal's Triangle II
 * <p>
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * <p>
 * Time Complexity: O(n^2) and O(n^2) and O(n)
 * Space Complexity: O(k) and O(1) and O(1)
 */
public class PascalsTriangleii {
    public List<Integer> getRow(int rowIndex) {
        List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        list.add(new ArrayList<Integer>());
        list.add(new ArrayList<Integer>());
        if (rowIndex == 0) {
            list.get(0).add(1);
            return list.get(0);
        }
        for (int i = 1; i <= rowIndex; i++) {
            ArrayList<Integer> tempList = list.get((i - 1) % 2);
            ArrayList<Integer> curList = list.get(i % 2);
            curList.add(1);
            for (int j = 0; j < tempList.size() - 1; j++) {
                curList.add(tempList.get(j) + tempList.get(j + 1));
            }
            curList.add(1);
            tempList.clear();
        }
        return list.get(rowIndex % 2);
    }

    // Less space and just use one list instead of two in the first method
    public List<Integer> getRow1(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            list.add(0);
        }
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i || j == 0)
                    list.set(j, 1);
                else
                    list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }

}
