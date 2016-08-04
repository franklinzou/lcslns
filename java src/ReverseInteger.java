/*
 * Reverse Integer
 * Tag: Math
 */
import java.util.*;

public class ReverseInteger {
    public int reverse(int x) {
        long res = 0; // for packing and also res for x = 0
        int rem = x;
        // basic method to extract effective digits (digits before last 0-part) and pack
        while(rem != 0){
            res = res * 10 + rem % 10;
            rem /= 10;
        }
        // check for overflow
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        return (int)res;
    }
}