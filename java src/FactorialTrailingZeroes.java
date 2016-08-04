/*
 * Factorial Trailing Zeroes
 * Tag: Math
 */
import java.util.*;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        // NOTE: type general: 0 is not defined: merged into general consideration
        // sum of numbers in [1,n] such that n % 5 = 0, n % 5^2 = 0, ...
        // number that contains m factors of 5 will be counted m times exactly
        // we can only focus on 5 as 2 is enough
        int res = 0, rem = n;
        while(rem > 0){
            rem /= 5;
            res += rem;
        }
        return res;
    }
}