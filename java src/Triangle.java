/*
 * Triangle
 * Tag: Array
 * Tag: Dynamic Programming
 */
import java.util.*;

public class Triangle {
    /* 
     * dp[i][j] indicates minimum path sum to bottom cells from cell (i, j)
     * dp[i][j] = Min(dp[i+1][j], dp[i+1][j+1]) + tri[i][j], i < n - 1
     * We do not consider valid extreme here as it must exist
     * NOTE: type: pollution problem of floating array
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        if(m == 0) return 0; // special judgement here as we return dp[0]
        int [] dp = new int[m + 1]; // dp[m] = 0 for dp[i + 1] access of when i = m - 1

        for(int i = m - 1; i >= 0; i --)
            for(int j = 0; j <= i; j ++)
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
                
        return dp[0];        
    }
}