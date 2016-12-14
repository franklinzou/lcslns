/*
 * Different Ways to Add Parentheses
 * Tag: Backtracking
 * Tag: Divide and Conquer
 */
import java.util.*;

public class DifferentWaysToAddParentheses {
    // Use memorization for efficiency
    Map<Integer, List<Integer>> mp = new HashMap<Integer, List<Integer>>();
    
    public List<Integer> diffWaysToCompute(String input) {
        return helper(input, 0, input.length() - 1);
    }
    
    // for each pure number expression, result is itself
    // for each operator-included expression must have a first layer split
    private List<Integer> helper(String input, int s, int e) {
        int rangeHash = new int[] {s, e}.hashCode();
        if(mp.containsKey(rangeHash)) return mp.get(rangeHash);
        List<Integer> res = new ArrayList<Integer>();
        for(int i = s; i <= e; i ++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                // get result from two sides of first layer split, and evaluate the result
                List<Integer> lList = helper(input, s, i - 1);
                List<Integer> rList = helper(input, i + 1, e);
                for(int lNum : lList)
                    for(int rNum : rList)
                        res.add(eva(lNum, rNum, c));
            } 
        }
        // if the expression is a pure number, return its value directly
        if(res.size() == 0) res.add(Integer.parseInt(input.substring(s, e + 1)));
        mp.put(rangeHash, res);
        return res;
    }
    
    private int eva(int op1, int op2, char opr) {
        int res = -1;
        switch(opr) {
            case '+': res = op1 + op2; break;
            case '-': res = op1 - op2; break;
            case '*': res = op1 * op2; break;
        }
        
        return res;
    }
}
