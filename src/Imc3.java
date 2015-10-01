/**
 * Created by alpb0130 on 9/26/15.
 */
public class Imc3 {
    public int solution(int[][] A) {
        // write your code in Java SE 8
        return findMax(0, 0, A);
    }

    int findMax(int rowIndex, int columnIndex, int[][] matrix) {
        if (rowIndex < matrix.length && columnIndex < matrix[0].length) {
            return matrix[rowIndex][columnIndex] +
                    Math.max(findMax(rowIndex + 1, columnIndex, matrix), findMax(rowIndex, columnIndex + 1, matrix));
        }
        if (rowIndex < matrix.length) {
            return matrix[rowIndex][columnIndex] + findMax(rowIndex + 1, columnIndex, matrix);
        }
        if (columnIndex < matrix[0].length) {
            return matrix[rowIndex][columnIndex] + findMax(rowIndex, columnIndex + 1, matrix);
        }
        return matrix[rowIndex][columnIndex];
    }
}
