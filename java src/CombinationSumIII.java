/*
 * Combination Sum III
 * Tag: Backtracking
 * Tag: Array
 */
import java.util.*;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, k, n, 1, 0, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(List<List<Integer>> res, int k, int n, int s, int preSum, List<Integer> preRes){
        // Direct Answer (possible no solution)
        if(preRes.size() == k){
            if(preSum == n) res.add(new ArrayList<Integer>(preRes));
            return;
        }

        for(int i = s; i <= 9 && i <= n; i++){
            preRes.add(i);
            helper(res, k, n, i + 1, preSum + i, preRes);
            preRes.remove(preRes.size() - 1);
        }
    }
}