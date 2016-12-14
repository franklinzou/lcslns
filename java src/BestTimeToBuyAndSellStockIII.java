/*
 * Best Time to Buy and Sell Stock III
 * Tag: Dynamic Programming
 * Tag: Array
 */
import java.util.*;

public class BestTimeToBuyAndSellStockIII {
    /*
     * buy1[i] indicates maximum profit of sequence in [S..i] ended by buy with 0 sell
     * sell1[i] indicates maximum profit of sequence in [S..i] ended by sell with 1 sell
     * buy2[i] indicates maximum profit of sequence in [S..i] ended by buy with 1 sell
     * sell2[i] indicates maximum profit of sequnece in [S..i] ended by sell with 2 sell
     * when i >= 1
     * buy1[i] = Max(buy[i-1], -p[i])
     * sell1[i] = Max(sell1[i-1], buy[i] + p[i])
     * buy2[i] = Max(buy2[i-1], sell1[i] - p[i])
     * sell2[i] = Max(sell2[i-1], buy2[i] + p[i])
     */    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = Integer.MIN_VALUE, sell2 = Integer.MIN_VALUE;
        for(int i = 0; i <= n - 1; i ++){
            // we do not consider Existence of valid sequence because they obviously exist
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        // it is simple to see sell2 >= sell1 as for any sell1 sequence, we can generate equal (buy and sell on the same day)
        return sell2; 
    }
}