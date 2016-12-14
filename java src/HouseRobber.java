/*
 * House Robber
 * Tag: Dynamic Programming
 */
import java.util.*;

public class HouseRobber {
    /*
     * dp[i] indicates the maximal income with only [S..i] elements
     * dp[0] = nums[0]. dp[i] = MAX(dp[i - 2] + nums[i], dp[i - 1]), i >= 2
     * dp[i - 2] + nums[i] for best robbing i outcome, dp[i - 1] for best not outcome
     */
    public int rob(int[] nums) {
        // NOTE: General: invalid access for preRes, res (silence value)
        // NOTE: General: sum model with default answer (res) (for case n == 0)
        int n = nums.length, preRes = 0, res = 0;
        for(int i = 0; i <= n - 1; i++){
            int tmp = res;
            res = Math.max(preRes + nums[i], res);
            preRes = tmp;
        }
        return res;
    }
}