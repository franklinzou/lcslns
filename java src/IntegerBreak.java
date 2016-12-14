/*
 * Integer Break
 * Tag: Dynamic Programming
 * Tag: Math
 */
import java.util.*;

public class IntegerBreak {
    public int integerBreak(int n) {
        // Useful conclusion: for any integer n > 4, (n - 3) * 3 > n, easy to show
        // TODO: full analysis
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == 4) return 4;
        int rem = n, res = 1;
        while(rem > 4){
            res *= 3;
            rem -= 3;
        }
        res *= rem;
        return res;
    }
}