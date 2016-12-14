/*
 * Climbing Stairs
 * Tag: Dynamic Programming
 */
import java.util.*;

public class ClimbingStairs {
    public int climbStairs(int n) {
        // dp[i] indicates plan count with i stairs. dp[1] = 1, dp[i] = dp[i - 1] + dp[i - 2] (i >= 2)
        // Note: General: sum model with default answer (in fact result for n = 1)
        int preRes = 1, res = 1;
        // Floating array: we guarantee res is the result for elements[S..i - 1] before i-iteration
        for(int i = 2; i <= n; i++){
            int tmp = res;
            res += preRes;
            preRes = tmp;
        }
        
        return res;        
    }
}