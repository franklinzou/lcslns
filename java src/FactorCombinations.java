/*
 * Factor Combinations
 * Tag: BackTracking
 */
import java.util.*;

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, n, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(List<List<Integer>> res, int n, List<Integer> preRes){
        // guarantee non-decreasing property of preRes
        int start = preRes.size() == 0 ? 2 : preRes.get(preRes.size() - 1);
        for(int i = start; i * i <= n; i++){
            if(n % i == 0){
                preRes.add(i);
                helper(res, n / i, preRes);
                preRes.remove(preRes.size() - 1);
            }
        }
        // go from sqrt(n) to n for efficiency
        // General: type: is invalid for first invocation. n = 1 is also included
        if(preRes.size() != 0){
            preRes.add(n);
            res.add(new ArrayList<Integer>(preRes));
            preRes.remove(preRes.size() - 1);
        }
    }
}