/*
 * Counting Bits
 * Tag: Dynamic Programming
 * Tag: Bit Manipulation
 */
import java.util.*;

public class CountingBits {
    /*
     * dp[i] indicates bit count for number i
     * dp[i] = dp[i >> 1] + (i & 1), consider get i by left shift and add final digit
     * Generally feasible for i with two or more digits, but also applies for 1-digit number (0 and 1)
     */
    public int[] countBits(int num) {
        int [] dp = new int[num + 1];
        for(int i = 0; i <= num; i++)
            dp[i] = dp[i >> 1] + (i & 1);
        return dp;
    }
}