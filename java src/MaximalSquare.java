/*
 * Maximal Square
 * Tag: Dynamic Programming
 */
import java.util.*;

public class MaximalSquare {
    /*
     * dp[i][j] indicates maximal length of square ended at (i, j)
     * if (i, j) is '0', dp[i][j] = 0
     * if (i, j) is '1', dp[i][j] = Min(dp[i-1][j] if valid, dp[i][j-1] if valid, dp[i-1][j-1] if valid) + 1
     */
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int [] dp = new int[n + 1]; // add dp[0][x] and dp[x][0] for invalid access
        int maxLen = 0;
        for(int i = 1; i <= m; i ++){
            int pre = 0; // for dp[i-1][j-1]
            for(int j = 1; j <= n; j ++){
                int tmp = dp[j];                
                if(matrix[i - 1][j - 1] == '1'){
                    dp[j] = Math.min(dp[j], Math.min(dp[j - 1], pre)) + 1;
                    maxLen = Math.max(maxLen, dp[j]);
                }
                else dp[j] = 0;
                pre = tmp;
            }
        }
        return maxLen * maxLen;        
    }
}