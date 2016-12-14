/*
 * Subsets II
 * Tag: Backtracking
 * Tag: Array
 */
import java.util.*;

public class SubsetsII {
	/*
	 * FP(pre_result, pos) = pre_result + 
	 * FP(pre_result + nums[I], I), I \in [pos, len()-1] DIST for nums
	 * NOTE pre_result itself is a fp
	 */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(res, nums, 0, new ArrayList<Integer>());
        return res;
    }
    
    /*
     * Validation:
     * fp = preRes[0,preRes.len()-1]
     * fp[preRes.len(), len()-1] FROM nums[pos, len()-1]
     */
    private void helper(List<List<Integer>> res, int[] nums, int pos, List<Integer> preRes){
        int n = nums.length;
        
        // Partial direct answer plus branching
        res.add(new ArrayList<Integer>(preRes));
        
        // When pos == n, there is no branching solution, which is handled by loop
        for(int i = pos; i <= n - 1; i ++){
	        if(i == pos || nums[i] != nums[i - 1]){
	            preRes.add(nums[i]);
	            helper(res, nums, i + 1,  preRes);
	            preRes.remove(preRes.size() - 1);
	        }
        }
    } 
}