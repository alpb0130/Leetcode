import java.util.HashSet;
import java.util.Set;

/**
 * Created by alpb0130 on 1/7/16.
 * <p>
 * 73. Set Matrix Zeroes
 * <p>
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * <p>
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class SetMatrixZeroes {
    // Time complexity: O(m * n). Space complexity: O(m + n)
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        Set<Integer> rowSet = new HashSet<Integer>();
        Set<Integer> colSet = new HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (rowSet.contains(i) || colSet.contains(j))
                    matrix[i][j] = 0;
        return;
    }

    // Time complexity: O(m * n). Space complexity: O(1)
    public void setZeroes1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        boolean rowZero = false, colZero = false;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0) rowZero = true;
                    if (j == 0) colZero = true;
                }
            }
        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        if (rowZero) {
            for (int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        }
        if (colZero) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
        return;
    }
}
