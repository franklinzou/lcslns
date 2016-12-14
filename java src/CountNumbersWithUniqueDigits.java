/*
 * Count Numbers with Unique Digits
 * Tag: Dynamic Programming
 * Tag: Backtracking
 * Tag: Math
 */
import java.util.*;

public class CountNumbersWithUniqueDigits {
    /*
     * digitRes[i] is the count for numbers in range [10^(n-1)..10^n) (or [100..~999..)), n-digit numbers without leading 0
     * digitRes[i] = digitRes[i - 1] * factor, for i >= 2
     * And we do sum to get result
     */
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        // default answer for n = 1. digitRes[i] is the result for range 
        int res = 10, digitRes = 9, factor = 9;
        for(int i = 2; i <= n; i++) {
            digitRes *= factor;
            res += digitRes;
            factor --;
        }
        return res;
    }
}