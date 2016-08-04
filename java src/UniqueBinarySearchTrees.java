/*
 * Unique Binary Search Trees
 * Tag: Tree
 * Tag: Dynamic Programming
 */
import java.util.*;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        // TODO: complete analysis
        int [] dp = new int[n + 1]; // number of unique BSTs with any n numbers
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            dp[i] = 0;
            // j indicates number of nodes in left branch
            for(int j = 0; j <= i - 1; j++) dp[i] += (dp[j] * dp[i - 1 - j]);
        }
        return dp[n];
    }
}