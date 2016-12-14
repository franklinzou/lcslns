/*
 * Distinct Subsequences
 * Tag: Dynamic Programming
 * Tag: String
 */
import java.util.*;

public class DistinctSubsequences {
    /*
     * dp[i][j] indicates count of methods of turning s.len(i) to t.len(j)
     * dp[i][j] = dp[i-1][j] (deleting final) if valid + dp[i-1][j-1] if valid and s[i-1] = t[j-1] (not deleting final)
     * dp[0][0] = 1 based on definition (self of s.len(0))
     */
    public int numDistinct(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        int [] dp = new int[len2 + 1];
        dp[0] = 1;
        // Just start from i as i == 0 is not applicable for either (dp[i-1][j], dp[i-1][j-1])
        // so we set up dp[0][x] directly
        for(int i = 1; i <= len1; i ++){
            int prev = dp[0]; // for dp[i-1][j-1]
            for(int j = 1; j <= len2; j ++){
                int tmp = dp[j];
                if(s.charAt(i - 1) == t.charAt(j - 1))
                    dp[j] += prev;
                prev = tmp;    
            }
        }
        return dp[len2];
    }
}