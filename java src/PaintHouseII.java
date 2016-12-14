/*
 * Paint House II
 * Tag: Dynamic Programming
 */
import java.util.*;

public class PaintHouseII {
    /*
     * dp[i][j] indicates painting houses[S..i] with house i painted by color j
     * dp[i][j] = Min(dp[i-1][J']) + costs[j]. J' = {j'|j'!=j}, i >= 1
     */
    public int minCostII(int[][] costs) {
        if(costs.length == 0 || costs[0].length == 0) return 0;
        int n = costs.length, k = costs[0].length;     
        // smallest index of minimum cost, minimum cost and second minimum cost.
        // NOTE: general: default answer, pre-lookup
        int [] mins = {-1, 0, 0}, lastMins = new int[3];
        for(int i = 0; i <= n - 1; i ++){
            for(int j = 0; j <= 2; j ++) lastMins[j] = mins[j];
            mins[0] = -1;
            mins[1] = mins[2] = Integer.MAX_VALUE;
            for(int j = 0; j <= k - 1; j ++){
                // simulate insertion sort
                int minVal = (j == lastMins[0] ? lastMins[2] : lastMins[1]) + costs[i][j];
                if(minVal < mins[2]) mins[2] = minVal;
                if(minVal < mins[1]){
                    mins[2] = mins[1];
                    mins[1] = minVal;
                    mins[0] = j;
                }
            }
        }
        
        return mins[1];
    }
}