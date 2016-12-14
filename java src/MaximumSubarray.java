/*
 * Maximum Subarray
 * Tag: Array
 * Tag: Dynamic Programming
 * Tag: Divide and Conquer
 */
import java.util.*;

public class MaximumSubarray {
    /*
     * dp[i] indicates largest sum of array ending at nums[i]
     * dp[i] = Math.max(nums[i], dp[i-1] + nums[i]): connect to previous optimum or not. i >= 1
     */
    public int maxSubArray(int[] nums) {
        /*
        // Dynamic programming method
        int n = nums.length, res = Integer.MIN_VALUE, endRes = Integer.MIN_VALUE; // invalid access
        for(int i = 0; i <= n - 1; i++){
            endRes = endRes < 0 ? nums[i] : endRes + nums[i];
            res = Math.max(res, endRes);
        }
        return res;
        */
        // divide and conquer
        int n = nums.length;
        if(n == 0) return 0;
        return rangeMaxSubArray(nums, 0, n - 1);
    }
    
    private int rangeMaxSubArray(int [] nums, int s, int e) {
        if(s == e) return nums[s];
        int m = (s + e + 1) / 2;
        int lMax = rangeMaxSubArray(nums, s, m - 1);
        int rMax = rangeMaxSubArray(nums, m, e);
        // we try to find optimal range that crosses the boundary, which contains elements 
        // nums[m] and nums[m + 1]. And we further divide to find optimal left and 
        // right sub range optimal, by combining which we find optimal cross-boundary range
        int lSum = nums[m - 1], rSum = nums[m], lMidMax = lSum, rMidMax = rSum;
        // Note: we use s instead of 0
        for(int i = m - 2; i >= s; i --) {
            lSum += nums[i];
            lMidMax = Math.max(lMidMax, lSum);
        }
        // Note: we use e instead of n
        for(int i = m + 1; i <= e; i ++) {
            rSum += nums[i];
            rMidMax = Math.max(rMidMax, rSum);
        }
        return Math.max(lMidMax + rMidMax, Math.max(lMax, rMax));
    }
}