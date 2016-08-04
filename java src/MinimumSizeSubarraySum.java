/*
 * Minimum Size Subarray Sum
 * Tag: Array
 * Tag: Binary Search
 * Tag: Two Pointers
 */
import java.util.*;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        // O(n) method: TODO: full analysis
        int minLen = Integer.MAX_VALUE;
        int l = 0, r = 0, sum = 0, n = nums.length;
        while(r < n){
            sum += nums[r];
            while(sum >= s){
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l++];
            }
            r++;
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
        
        // TODO: O(nlogn), binary search method
    }
}