/*
 * Generate Parentheses
 * Tag: Backtracking
 * Tag: String
 */
import java.util.*;

public class GenerateParentheses {
	/*
	 * FPS(n, preS) = FPS(n, preS + "(") + FPS(n, preS+ ")"), n * 2 - preS.len() >= 1
	 * FPS(n, preS) = preS if preS is valid, n * 2 - preS.len() == 0
	 * FPS is Empty, n < 0
	 */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(res, 0, 0, n, new StringBuilder());
        return res;
    }
    /*
     * Validation (given state oriN, pre_result):
     * fp has prefix pre_result
     * fp has oriN "("s, oriN ")"s, and l >= r for any prefix of newS
     */
    private void helper(List<String> res, int l, int r, int oriN, StringBuilder resBld){
        // No solution-prune from oriN or pre_result (pre-pruning)
        if(oriN < 0 || l > oriN || r > oriN || r > l) return;
        
        // Direct Solution - validation is passed given no pruning is done
        if(resBld.length() == 2 * oriN){
            res.add(resBld.toString());
            return;
        }
        // Branching
        int oriLen = resBld.length();
        
        resBld.append("(");
        helper(res, l + 1, r, oriN, resBld);
        resBld.setLength(oriLen);

        resBld.append(")");
        helper(res, l, r + 1, oriN, resBld);
        resBld.setLength(oriLen);
    }
}