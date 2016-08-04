/*
 * Number of 1 Bits
 * Tag: Bit Manipulation
 */
import java.util.*;

public class NumberOfOneBits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // use n & (n - 1) trick, keep removing final 1 and count, till n is zero
        int cnt = 0;
        while(n != 0){
            n = n & (n - 1);
            cnt ++;
        }
        return cnt;
    }
}