/*
 * Letter Combinations of a Phone Number
 * Tag: BackTracking
 * Tag: String
 */
import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    private static final String [] syms = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    // TODO: complexity analysis
    public List<String> letterCombinations(String digits) {
        return helper(digits.toCharArray(), 0, digits.length());
    }
    
    private List<String> helper(char[] digits, int s, int len) {
        List<String> res = new ArrayList<String>();
        if(len == 0) return res; // special case, will only be here if input is ""
        if(len == 1){
            for(char c : syms[digits[s] - '1'].toCharArray())
                res.add(String.valueOf(c));
            return res;
        }
        List<String> lRes = helper(digits, s, len / 2);
        List<String> rRes = helper(digits, s + len / 2, len - len / 2);
        for(int i = 0; i <= lRes.size() - 1; i++)
            for(int j = 0; j <= rRes.size() - 1; j++)
                res.add(lRes.get(i) + rRes.get(j));
        return res;        
    }
}