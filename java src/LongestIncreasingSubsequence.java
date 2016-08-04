/*
 * Longest Increasing Subsequence
 * Tag: Binary Search
 * Tag: Dynamic Programming
 */
import java.util.*;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // we guarantee with elements visited, for any i < size, there exists LIS with length i + 1 and smallest possible
        // ending element is tails[i]
        int n = nums.length, size = 0; // size of longest LIS
        int [] tails = new int[n];
        // find smallest position in tails not smaller than nums[i] or size if no such element
        for(int i = 0; i <= n - 1; i++){
            int l = 0, r = size - 1;
            while(l <= r){
                int m = l + (r - l + 1) / 2;
                if(tails[m] < nums[i]) l = m + 1;
                else r = m - 1;
            }
            // l + 1 is the maximum length of LIS we can create with nums[i] (even when l equals size)
            tails[l] = nums[i];
            // update size if possible
            if(l == size) size++;
        }
        
        return size;
        // TODO: dynamic programming method
    }
}