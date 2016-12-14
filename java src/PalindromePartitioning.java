/*
 * Palindrome Partitioning
 * Tag: Dynamic Programming
 * Tag: Backtracking
 */
import java.util.*;

public class PalindromePartitioning {
    /*
     * dp[i][j] indicates whether s[i..j] is a palindrome
     * dp[i][j] = (s[i] == s[j] && dp[i+1][j-1]) if j - i > 1
     * dp[i][j] = (s[i] == s[j]) if j = i + 1
     * dp[i][j] = true if i == j
     */ 
    public List<List<String>> partition(String s) {
        // when s.length == 0, result is merged, controlled by loop and ending condition
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        for(int i = n - 1; i >= 0; i --){
            dp[i][i] = true;  
            for(int j = i + 1; j <= n - 1; j ++)
                if(s.charAt(i) == s.charAt(j) && (j - i == 1 || dp[i + 1][j - 1]))
                    dp[i][j] = true;
        }
        List<List<String>> res = new ArrayList<List<String>>();
        helper(res, dp, 0, s, new ArrayList<String>());
        return res;
    }
    
    private void helper(List<List<String>> res, boolean [][] dp, int pos, String s, List<String> preList){
        int len = s.length();
        if(pos == len){
            res.add(new ArrayList<String>(preList));
            return;
        }
        for(int i = pos; i <= len - 1; i++){
            if(dp[pos][i]){
                preList.add(s.substring(pos, i + 1));
                helper(res, dp, i + 1, s, preList);
                preList.remove(preList.size() - 1);
            }
        }
    }
}