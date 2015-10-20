/**
 * Created by alpb0130 on 9/30/15.
 *
 * Same Tree
 *
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 * time complexity O(log n)
 */

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = 0, columnIndex = 0;
        int upper = matrix.length - 1, lower = 0;
        if (matrix.length == 0 && matrix[1].length == 0)
            return false;
        while (upper >= lower) {
            rowIndex = (upper + lower) / 2;
            if (target < matrix[rowIndex][0]) {
                upper = rowIndex - 1;
            } else if (target > matrix[rowIndex][0]) {
                lower = rowIndex + 1;
            } else {
                return true;
            }
        }
        if (target < matrix[rowIndex][0]) {
            rowIndex -= 1;
        }
        if (rowIndex < 0)
            return false;
        upper = matrix[rowIndex].length - 1;
        lower = 0;
        while (upper >= lower) {
            columnIndex = (upper + lower) / 2;
            if (target < matrix[rowIndex][columnIndex]) {
                upper = columnIndex - 1;
            } else if (target > matrix[rowIndex][columnIndex]) {
                lower = columnIndex + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
