/*
 * Expression Add Operators
 * Tag: Divide and Conquer
 * Tag: Backtracking
 */
import java.util.*;

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if(num.length() == 0) return res;
        StringBuilder resBld = new StringBuilder();
        helper(num, resBld, 0, target, 1, res);
        return res;
    }
    
    // we need to find expression from num[s..E] such that factor * first number and following expression
    // gives target
    // Basic idea: if expression has operator, we iterate over possible positions and type; if not, we check 
    // numerical value with target directly. Use tricky sub-problem definition to address issue of * and -.
    private void helper(String num, StringBuilder resBld, int s, long target, long factor, List<String> res) {
        int len = num.length(), preLen = resBld.length();
        // iterate over all possible ends of first number
        for(int i = s; i <= len - 2; i ++) {
            // Note: type: avoid leading zero in the expression
            if(i > s && num.charAt(s) == '0') break;
            long val = Long.parseLong(num.substring(s, i + 1));
            resBld.append(num.charAt(i));
            
            resBld.append('*');
            helper(num, resBld, i + 1, target, factor * val, res);
            resBld.deleteCharAt(resBld.length() - 1);  

            // Note: '-' only takes effect on the first number, so we treat it as a -1 factor 
            // to the first number
            resBld.append('-');
            helper(num, resBld, i + 1, target - factor * val, -1, res);
            resBld.deleteCharAt(resBld.length() - 1); 
            
            resBld.append('+');
            helper(num, resBld, i + 1, target - factor * val, 1, res);
            resBld.deleteCharAt(resBld.length() - 1);
        }
        // NOTE: type: conservative ending
        // avoid s exceeds length of num in the following iterations
        resBld.append(num.charAt(len - 1));
        // avoid leading zero
        if((num.charAt(s) != '0' || s == len - 1) && factor * Long.parseLong(num.substring(s, len)) == target)
            res.add(resBld.toString());
        resBld.setLength(preLen);
    }
}
