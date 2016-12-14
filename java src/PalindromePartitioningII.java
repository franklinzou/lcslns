/*
 * Palindrome Partitioning II
 * Tag: Dynamic Programming
 */
import java.util.*;

public class PalindromePartitioningII {
    /*
     * isP[i][j] indicates if s[i..j] is palindrome
     * dp[i] indicates minimum cut for s[i..n - 1]
     * dp[i] = MIN(1 + dp[J+1], 0 if isP[i..n - 1]), J = {j|j >= i && j < n-1 && isP[j][n]}
     */
    public int minCut(String s) {
        int n = s.length();
        if(n == 0) return 0; // for returning dp[0]
        boolean [][] isP = new boolean[n][n];
        int [] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = n - 1; i >= 0; i --){
            for(int j = i; j <= n - 1; j++)
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || isP[i + 1][j - 1])){
                    isP[i][j] = true;
                    if(j == n - 1) dp[i] = 0;
                    else dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }    
        }

        return dp[0];
    }
}