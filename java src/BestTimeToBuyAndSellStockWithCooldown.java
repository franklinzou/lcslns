/*
 * Best Time to Buy and Sell Stock with Cooldown
 * Tag: Dynamic Programming
 */
import java.util.*;

public class BestTimeToBuyAndSellStockWithCooldown {
    /*
     * sell[i] indicates maximal profit from a sequence ended by sell in period [S..i]
     * buy[i] indicates maximal profit from a sequence ended by buy in period [S..i]
     * sell[i] = Max(sell[i - 1], buy[i] + prices[i])
     * buy[i] = Max(buy[i - 1], Max(0 - prices[i] #append nothing#, sell[i - 2] - prices[i] #append cooldowned sell#))
     */
    public int maxProfit(int[] prices) {
        int sell = Integer.MIN_VALUE, buy = Integer.MIN_VALUE, preSell = 0;
        int n = prices.length;
        if(n == 0) return 0; // cannot be merged
        for(int i = 0; i <= n - 1; i ++){
            buy = Math.max(buy, Math.max(0, preSell) - prices[i]);
            preSell = sell;
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }
}