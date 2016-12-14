/*
 * House Robber II
 * Tag: Dynamic Programming
 */
import java.util.*;

public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        // when n >= 2, any feasible plan for ring problem must be a plan for [0..n - 2] or [1..n - 1] problem
        // and any feasible plan for [0..n - 2] or [1..n - 1] problem must be feasible for ring problem
        return Math.max(helper(nums, 0), helper(nums, 1));
    }
    // gurantee nums.length >= 1, consider maximum from s with length nums.length - 1
    private int helper(int[] nums, int s) {
        // dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i])
        int res = nums[s], preRes = 0, len = nums.length - 1;
        for(int i = 1; i <= len - 1; i++){
            int tmp = res;
            res = Math.max(res, preRes + nums[s + i]); // NOTE i for offset here
            preRes = tmp;
        }
        return res;
    }
}