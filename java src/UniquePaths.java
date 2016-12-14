/*
 * Unique Paths
 * Tag: Array
 * Tag: Dynamic Programming
 */
import java.util.*;

public class UniquePaths {
    /*
     * dp[i][j] for number of ways to access position (i, j)
     * dp[i][j] = dp[i-1][j] + dp[i][j-1] for i >= 1, j >= 1
     */
    public int uniquePaths(int m, int n) {
        // actually can be calculated as C_{m - 1 + n - 1}^{n - 1}
        // floating array: can access dp[i][j-1] and dp[i-1][j] directly
        int [] row = new int[n + 1]; // default 0 for rows[0]
        // invalid access assignment (dp[-1][0]) for dp[0][0]
        row[0] = 1;

        for(int i = 1; i <= m; i++)
            // only update for j = [1..n-1], as dp[i][0] = dp[i-1][0]
            for(int j = 1; j <= n - 1; j++)
                row[j] = row[j] + row[j - 1];
                
        return row[n - 1];
    }
}