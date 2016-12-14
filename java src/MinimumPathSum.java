/*
 * Minimum Path Sum
 * Tag: Array
 * Tag: Dynamic Programming
 */
import java.util.*;

public class MinimumPathSum {
    /*
     * dp[i][j] indicates minimum path sum at cell (i, j)
     * dp[i][j] = Math.min(dp[i][j-1] + dp[i-1][j]), i >= 1, j >= 1
     * We do not consider invalid extremes as feasible plan must exist
     */
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int [] dp = new int[n]; 
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // avoid sequence start problem
        
        for(int i = 0; i <= m - 1; i++)
            for(int j = 0; j <= n - 1; j++){
                int leftVal = j == 0 ? Integer.MAX_VALUE : dp[j - 1];
                // NOTE: General: very tricky if leftVal and dp[j] are both MAX_INT
                dp[j] = Math.min(leftVal, dp[j]) + grid[i][j];
            }
                
        return dp[n - 1];        
    }
}