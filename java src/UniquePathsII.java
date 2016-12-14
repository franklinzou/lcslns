/*
 * Unique Paths II
 * Tag: Dynamic Programming
 * Tag: Array
 */
import java.util.*;

public class UniquePathsII {
    /*
     * dp[i][j] indicates number of ways from cell(0, 0) to cell (i, j) if cell (i, j) = 1, or 0 otherwise
     * dp[i][j] = dp[i-1][j] + dp[i][j-1], i >= 1, j >= 1
     * TODO: consider cell (0, 0) problem
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int [] dp = new int[n];
        dp[0] = 1;
        for(int i = 0; i <= m - 1; i++)
            for(int j = 0; j <= n - 1; j++){
                if(obstacleGrid[i][j] == 1) dp[j] = 0;
                // use judgement to avoid invalid access
                else if(j > 0) dp[j] += dp[j - 1];
            }
        return dp[n - 1];    
    }
}