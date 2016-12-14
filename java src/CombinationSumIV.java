/*
 * Combination Sum IV
 * Tag: Dynamic Programming
 */
import java.util.*;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int [] dp = new int[target + 1];
        dp[0] = 1; // invalid access
        int n = nums.length;
        // TODO: full analysis
        for(int i = 1; i <= target; i++)
            for(int j = 0; j <= n - 1; j++)
                if(i >= nums[j])
                    dp[i] += dp[i - nums[j]];
        
        return dp[target];
    }
}