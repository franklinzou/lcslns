/*
 * Ugly Number II
 * Tag: Math
 * Tag: Dynamic Programming
 * Tag: Heap
 */
import java.util.*;

public class UglyNumberII {
    /*
     * dp[j] satisfies that uNums[dp[j]] is the smallest ugly number such that uNums[dp[j]] * factor[j] > res
     * => uNums[dp[j]] * factor[j] is the smallest ugly with factor factor[j] larger than res
     * Min(uNums[dp[J]] * factor[J]) is the smallest unly number larger than res.
     */
    private static int [] factors = {2, 3, 5};
    public int nthUglyNumber(int n) {
        int [] uNums = new int[n], dp = {0, 0, 0};
        uNums[0] = 1;
        for(int i = 1; i <= n - 1; i++){
            uNums[i] = Integer.MAX_VALUE;
            for(int j = 0; j <= 2; j++) uNums[i] = Math.min(uNums[i], uNums[dp[j]] * factors[j]);
            for(int j = 0; j <= 2; j++) 
                if(uNums[i] == uNums[dp[j]] * factors[j]) dp[j] ++;
        }
        return uNums[n - 1];
    }
}