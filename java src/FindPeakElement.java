/*
 * Find Peak Element
 * Tag: Binary Search
 * Tag: Array
 */
import java.util.*;

public class FindPeakElement {
	// TODO: full analysis
    public int findPeakElement(int[] nums) {
        int n = nums.length, l = 0, r = n - 1;
        // we guarantee nums[l - 1] < nums[l] and nums[r] > nums[r + 1]; a peak is found when l == r
        while(l < r){
            int m = l + (r - l + 1) / 2;
            // as m is the latter index and l < r, we have m \in (0, n], therefore we use
            // m - 1 notation to avoid out-of-bound problem
            if(nums[m] > nums[m - 1]) l = m;
            else r = m - 1;
        }
        return l;
    }
}