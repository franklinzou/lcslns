/*
 * Largest Divisible Subset
 * Tag: Math
 * Tag: Dynamic Programming
 */
import java.util.*;

public class LargestDivisibleSubset {
    /*
     * dp[i] indicates maximal length ending with nums[i]
     * dp[i] = MAX(dp[j]) such that j < i and nums[i] % nums[j] = 0
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // NOTE: general: default answer for indicator (-1), merged into backtracking
        // NOTE: general: pre-lookup: cannot use 0 here as 
        // it is possible that same value as default does not update maxEnd
        int n = nums.length, maxEnd = -1, maxSize = Integer.MIN_VALUE;
        int [] dp = new int[n], pre = new int[n];
        Arrays.fill(pre, -1);
        Arrays.sort(nums);
        for(int i = 0; i <= n - 1; i++){
            // NOTE: general: sum model, conditional update, default answer
            for(int j = i - 1; j >= 0; j --){
                if(nums[i] % nums[j] == 0 && dp[j] > dp[i]){
                    pre[i] = j;
                    dp[i] = dp[j]; // child number only
                }
            }
            dp[i] += 1;
            if(dp[i] > maxSize){
                maxEnd = i;
                maxSize = dp[i];
            }
        }
        // backtracking
        List<Integer> res = new ArrayList<Integer>();
        int cur = maxEnd;
        while(cur != -1){
            res.add(0, nums[cur]);
            cur = pre[cur];
        }
        return res;
    }
}