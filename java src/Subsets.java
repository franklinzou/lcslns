/*
 * Subsets
 * Tag: Bit Manipulation
 * Tag: Array
 * Tag: Backtracking
 */
import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length, cnt = 1 << n; // the count of distinct lists
        for(int i = 0; i <= cnt - 1; i++){
            int rem = i;
            ArrayList<Integer> subset = new ArrayList<Integer>();
            // j indicates the ind of bit to take in the next iteration (from right to left)
            for(int j = 0; j <= n - 1; j++){
                if((rem & 1) == 0) subset.add(nums[j]);
                rem >>= 1;           
            }
            res.add(subset);
        }
        return res;
        // TODO: backtracking method
    }
}