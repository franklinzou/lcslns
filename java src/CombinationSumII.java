/*
 * Combination Sum II
 * Tag: Backtracking
 * Tag: Array
 */
import java.util.*;

public class CombinationSumII {
	/*
	 * Similar to Combination Sum, but add duplicate removal
	 */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        helper(res, candidates, 0, 0, target, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] candidates,
        int s, int preSum, int target, List<Integer> preRes) {
        if(target == preSum){
            res.add(new ArrayList<Integer>(preRes));
            return;
        }
        // target >= candidates[i]: pruning with sorting
        for(int i = s; i <= candidates.length - 1 && target >= candidates[i]; i++){
            // we only take first occurrence of each distinct number in range [s..E] when array
        	// is sorted
            if(i == s || candidates[i] != candidates[i - 1]){
                preRes.add(candidates[i]);
                helper(res, candidates, i + 1, preSum + candidates[i], target, preRes);
                preRes.remove(preRes.size() - 1);
            }
        }
    }
}