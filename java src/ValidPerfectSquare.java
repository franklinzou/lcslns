/*
 * Valid Perfect Square
 * Tag: Binary Search
 * Tag: Math
 */
import java.util.*;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        // find smallest number i in [1,num] whose i^2 >= num; can use binary search as i^2 is non-decreasing
        // NOTE: still need to use long for m (an oprand) to guarantee enough space for product
        int l = 1, r = num;
        while(l <= r){
            int m = l + (r - l + 1) / 2;
            if((long)m * m < num) l = m + 1;
            else r = m - 1;
        }
        return l * l == num;
    }
}