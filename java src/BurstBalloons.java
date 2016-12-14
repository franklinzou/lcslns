/*
 * Burst Balloons
 * Tag: Divide and Conquer
 * Tag: Dynamic Programming
 */
import java.util.*;

public class BurstBalloons {
    /*
     * dp[i][j] indicates maximum coin we can get by bursting balloons in range [i+1..j-1]
     * dp[i][j] = Max(dp[i][K] if k - i > 1 + dp[K][j] if j - k > 1 + nums[i]*nums[j]*nums[K])
     * j - i >= 2 && k - i >= 1 && j - k >= 1
     * dp[i][j] = 0 , j - i = 1 for invalid access
     */
    public int maxCoins(int[] nums) {
        int [] numbers = new int [nums.length + 2];
        numbers[0] = numbers[nums.length + 1] = 1;
        for(int i = 0; i <= nums.length - 1; i ++) numbers[i + 1] = nums[i];
        int n = numbers.length;
        int [][] dp = new int[n][n];
        for(int i = n - 2; i >= 0; i --)
            for(int j = i + 2; j <= n - 1; j ++)
                for(int k = i + 1; k <= j - 1; k ++)
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + numbers[i] * numbers[k] * numbers[j]);
        
        return dp[0][n - 1];            
    }
}