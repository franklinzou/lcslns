/*
 * Interleaving String
 * Tag: Dynamic Programming
 * Tag: String
 */
import java.util.*;

public class InterleavingString {
    /*
     * dp[i][j] indicates whether s1.len(i) and s2.len(j) can form s3.len(i+j). s.len(0) indicates ""
     * dp[i][j] = (dp[i-1][j] && s1[i] = s3[i+j-1]) if valid OR (dp[i][j-1] && s2[j] = s3[i+j-1]) if valid
     * dp[0][0] = true based on definition
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length();
        if(s3.length() != len1 + len2) return false; // avoid (i+j-1) is valid for s3
        boolean [] dp = new boolean[len2 + 1];
        dp[0] = true;
        for(int i = 1; i <= len2 && s3.charAt(i - 1) == s2.charAt(i - 1); i ++) dp[i] = true;
        for(int i = 1; i <= len1; i ++){
            // NOTE: type: avoid invalid access
            dp[0] = dp[0] && s1.charAt(0) == s3.charAt(0);
            for(int j = 1; j <= len2; j ++)
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) 
                || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
        }
        
        return dp[len2];
    }
}