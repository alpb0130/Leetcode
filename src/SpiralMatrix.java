/**
 * Created by alpb0130 on 10/22/15.
 * <p>
 * Spiral Matrix
 * <p>
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example, Given the following matrix:
 * [[ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]]
 * You should return [1,2,3,6,9,8,7,4,5].
 * <p>
 * Time complexity: O (m * n)
 * Space complexity: O (m * n)
 */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> spiralList = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return spiralList;
        }
        int upper = matrix.length - 1, lower = 0, left = 0, right = matrix[0].length - 1;
        while (upper >= lower && right >= left) {
            for (int i = left; i <= right; i++) {
                spiralList.add(matrix[lower][i]);
            }
            lower++;
            for (int i = lower; i <= upper; i++) {
                spiralList.add(matrix[i][right]);
            }
            right--;
            if (upper < lower) {
                break;
            }
            for (int i = right; i >= left; i--) {
                spiralList.add(matrix[upper][i]);
            }
            upper--;
            if (left > right) {
                break;
            }
            for (int i = upper; i >= lower; i--) {
                spiralList.add(matrix[i][left]);
            }
            left++;
        }
        return spiralList;
    }
}
