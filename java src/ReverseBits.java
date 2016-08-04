/*
 * Reverse Bits
 * Tag: Bit Manipulation
 */
import java.util.*;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // basic method: 
        // before each iteration, last i bits in result is result for last i bits in original n,
        // and we need to put last 32 - i bits in current n at the back of res
        int res = 0;
        for(int i = 0; i <= 31; i++){
            res <<= 1;
            res |= n & 1;
            n >>= 1;
        }
        return res;
    }
    // TODO: cache-friendly version
}