/*
 * Coin Change
 * Tag: Dynamic Programming
 */
import java.util.*;

public class CoinChange {
    /*
     * dp[i] indicates minimum coin count to make up amount i with coins[S..j]
     * If J_i = {j|plans for i - coins[j]} is not empty, dp[i] = min(dp[amount-J_i]) + 1; otherwise, dp[i] = INF
     * TODO: full analysis
     */
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // invalid access value
        for(int i = 1; i <= amount; i++)
            for(int j = 0; j <= coins.length - 1; j++)
                if(i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                    
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];            
    }
}