/*
 * Best Time to Buy and Sell Stock
 * Tag: Dynamic Programming
 */
import java.util.*;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // find i, j such that i <= j that maximizes prices[j] - prices[i]
        // dp[i] to maintain smallest number in [S..i]
    	// use default answer to deal with the case n == 0
        int preMin = Integer.MAX_VALUE, res = 0, n = prices.length;
        for(int i = 0; i <= n - 1; i++){
            preMin = Math.min(prices[i], preMin);
            res = Math.max(res, prices[i] - preMin);
        }
        return res;
    }
}