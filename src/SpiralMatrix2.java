/**
 * Created by alpb0130 on 10/22/15.
 * <p>
 * Spiral Matrix II
 * <p>
 * Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 * For example, Given n = 3,
 * You should return the following matrix:
 * [[ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]]
 * <p>
 * Time Complexity: O (n * n)
 * Space Complexity: O (n * n)
 */
public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        int upper = matrix.length - 1, lower = 0, left = 0, right = matrix[0].length - 1;
        int num = 1;
        while (upper >= lower && right >= left) {
            for (int i = left; i <= right; i++) matrix[lower][i] = num++;
            lower++;
            if (upper < lower) break;
            for (int i = lower; i <= upper; i++) matrix[i][right] = num++;
            right--;
            if (left > right) break;
            for (int i = right; i >= left; i--) matrix[upper][i] = num++;
            upper--;
            for (int i = upper; i >= lower; i--) matrix[i][left] = num++;
            left++;
        }
        return matrix;
    }
}
