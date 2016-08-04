/*
 * Sqrt(x)
 * Tag: Binary Search
 * Tag: Math
 */
import java.util.*;

public class SqrtX {
    public int mySqrt(int x) {
        // the greatest number i in [1,x] with i * i <= x
        // typical selecting-r binary search
        // guarantee for any i < l, i^2 <= x; for any i > r, i^2 > x. So when l > r, select r
        long l = 0, r = x; // NOTE: we use long here as when r = Integer.MAX_VALUE, r - l + 1 will exceed the maximum!!
        while(l <= r){
            long m = l + (r - l + 1) / 2;
            // long here!!
            if(m * m <= x) l = m + 1;
            else r = m - 1;
        }
        return (int)r;
        
        // TODO: Newton' method!!        
    }
}