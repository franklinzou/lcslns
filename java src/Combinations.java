/*
 * Combinations
 * Tag: BackTracking
 */
import java.util.*;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, 1, n, k, new ArrayList<Integer>());
        return res;
    }
    
    // append results of combine(s, n, k) to preRes before putting into res
    private void helper(List<List<Integer>> res, int s, int n, int k, List<Integer> preRes){
        if(k == 0){
            res.add(new ArrayList<Integer>(preRes));
            return;
        }
        // use branching control to avoid invalid input (n - s + 1 < k) for next invocation
        // (actually can also stop invalid input for self invocation as well )
        for(int i = s; i <= n - k + 1; i++){
            preRes.add(i);
            helper(res, i + 1, n, k - 1, preRes);
            preRes.remove(preRes.size() - 1);
        }
    }
}