/*
 * Range Sum Query 2D - Immutable
 * Tag: Dynamic Programming
 */
import java.util.*;

public class NumMatrix {
    // preSums[i][j] indicates SUM([0:i-1, 0:j-1]), SUM([0,-1, (0,-1])) = 0 for invalid access
    // When invalid access happens, it means addition or substraction is not necessary, so we use 0
    private int [][] preSums;
    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        preSums = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i ++)
            for(int j = 1; j <= n; j ++)
                preSums[i][j] = preSums[i - 1][j] + preSums[i][j - 1] + matrix[i - 1][j - 1] - preSums[i - 1][j - 1];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSums[row2 + 1][col2 + 1] - preSums[row2 + 1][col1] - preSums[row1][col2 + 1] + preSums[row1][col1];
    }
}