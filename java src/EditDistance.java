/*
 * Edit Distance
 * Tag: String
 * Tag: Dynamic Programming
 */
import java.util.*;

public class EditDistance {
    /*
     * dp[i+1][j+1] indicates minimum steps to convert word1[S..i] to word2[S..j], dp[0][X] indicates convert from ""
     * if word1[i] == word2[j], dp[i][j] = dp[i-1][j-1] <= dp[i-1][j-1] <= dp[i-1][j] + 1 as we can simply get (i-1,j-1)
     * by deleting from (i - 1, j) or (i, j - 1)
     * if word1[i] != word2[j], dp[i][j] = Min(dp[i-1][j] + 1 #delete at word1 or insert at word2)#, 
     * Min(dp[i][j-1] + 1 #insert at word2 or delete at word1#, dp[i-1][j-1] + 1 #replace at word1# )), i >= 1 && j >= 1
     * Initialial values based on defintions: a blank plan is feasible, so step count is 0
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int [][] dp = new int [len1 + 1][len2 + 1];
        // 
        for(int i = 1; i <= len1; i ++) dp[i][0] = i;
        for(int i = 1; i <= len2; i ++) dp[0][i] = i;
        for(int i = 1; i <= len1; i ++)
            for(int j = 1; j <= len2; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
            }
        return dp[len1][len2];    
    }
}