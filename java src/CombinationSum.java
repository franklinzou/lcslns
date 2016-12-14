/*
 * Combination Sum
 * Tag: Backtracking
 * Tag: Array
 */
import java.util.*;

public class CombinationSum {
	/*
	 * FP(candidates, s, target, pre_result) = 
	 * FP(candidates, I, target, pre_result ++ candidates[I]) I \in [s, len()-1]
	 * pre_sum == target, result is pre_result, as sum of pre_result is pre_sum, and any extra addition would
	 * make sum exceed target (as all elements are positive)
	 */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, candidates, 0, 0, target, new ArrayList<Integer>());
        return res;
    }
    /*
     * Validation (given candidates, s, target):
     * sum of fp equals target
     * fp has prefix pre_result
     * fp.last(len()-pre_result.len()) only contains numbers in candidates.last(len()-s)
     */
    private void helper(List<List<Integer>> res, int [] candidates, int s, int preSum, int target, List<Integer> preRes){
        // Direct answer
    	if(preSum == target){
            if(preRes.size() != 0) res.add(new ArrayList<Integer>(preRes));
            return;
        }
        // target >= candidates[i]: pruning with sorting
        for(int i = s; i <= candidates.length - 1 && preSum + candidates[i] <= target; i ++){
            preRes.add(candidates[i]);
            helper(res, candidates, i, preSum + candidates[i], target, preRes);
            preRes.remove(preRes.size() - 1);
        }
    }
}