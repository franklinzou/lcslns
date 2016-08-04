/*
 * Roman to Integer
 * Tag: Math
 * Tag: Binary Search
 */
import java.util.*;

public class DivideTwoIntegers {
    // find greatest number i such that abs(divisor) * i <= dividend
    public int divide(int dividend, int divisor) {
        // NOTE: abs-calculation: use long to avoid overflow in conversion
        long absDividend = Math.abs((long)dividend), absDivisor = Math.abs((long)divisor), res = 0, rem = absDividend;
        // General: scope-changing type, with res = 0 as default answer
        while(rem >= absDivisor){
            long factor = 1, subPart = absDivisor;
            // General: find smallest/greatest desirable number!!
            while(subPart << 1 <= rem){
                subPart <<= 1;
                factor <<= 1;
            }
            res += factor;
            rem -= subPart;
        }
        
        if((dividend ^ divisor) >> 31 != 0) res = -res;
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)res;
    }
}