/*
 * Maximum Product Subarray
 * Tag: Array
 * Tag: Dynamic Programming
 */
import java.util.*;

public class MaximumProductSubarray {
    /*
     * endMin[i] indicates minimum product over range ending at i, similar for endMax[i]
     */	
    public int maxProduct(int[] nums) {
        // NOTE: type: multiplication transfer equation is tricky.
        int endMin = nums[0], endMax = nums[0], res = nums[0], n = nums.length;
        for(int i = 1; i <= n - 1; i++){
            int p1 = endMin * nums[i], p2 = endMax * nums[i];
            endMin = Math.min(Math.min(p1, p2), nums[i]);
            endMax = Math.max(Math.max(p1, p2), nums[i]);
            res = Math.max(endMax, res);
        }
        
        return res;
    }
}