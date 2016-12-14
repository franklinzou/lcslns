/*
 * Maximum Size Subarray Sum Equals k
 * Tag: Hash Table
 */
import java.util.*;

public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        /*
         * transform problem with preSum array:
         * find i, j such that i < j and pre[j] - pre[i] = k with maximal j - i
         * Use preSum[-1] = 0, and calculate preSum[i] at runtime
         */
        // earliest occurrence j of preSum value i to guarantee best range
        Map<Integer, Integer> earOcr = new HashMap<Integer, Integer>();
        earOcr.put(0, -1); // pre[-1] = 0
        int sum = 0, res = 0;
        for(int i = 0; i <= nums.length - 1; i ++) {
            sum += nums[i];
            // check if there exists i such that pre[i] = k - sum
            if(earOcr.containsKey(sum - k)) res = Math.max(res, i - earOcr.get(sum - k));
            if(!earOcr.containsKey(sum)) earOcr.put(sum, i);
        }
        return res;
    }
}
