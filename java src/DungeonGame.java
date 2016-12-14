/*
 * Dungeon Game
 * Tag: Binary Search
 * Tag: Dynamic Programming
 */
import java.util.*;

public class DungeonGame {
    /*
     * dp[i][j] indicates initial minimum health to right-bottom cell at cell (i, j)
     * dp[i][j] = Max(Min(dp[i+1][j] if valid, dp[i][j+1] if valid) - dungeon[i][j],1)
     * dp[m-1][n-1] = dungeon[m-1][n-1] > 0 ? 1 : -dungeon[m-1][n-1] + 1
     */
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length == 0 || dungeon[0].length == 0) return 0; // undefined case
        int m = dungeon.length, n = dungeon[0].length;
        int [] dp = new int[n];        
        Arrays.fill(dp, Integer.MAX_VALUE); // for invalid access
        dp[n - 1] = 1; // Tricky point here
       
        for(int i = m - 1; i >= 0; i --){
            // omit dp[j + 1] when j = n - 1
            dp[n - 1] = Math.max(dp[n - 1] - dungeon[i][n - 1], 1);
            for(int j = n - 2; j >= 0; j --)
                dp[j] = Math.max(Math.min(dp[j], dp[j + 1]) - dungeon[i][j], 1);
        }
                
        return dp[0];        
    }
}