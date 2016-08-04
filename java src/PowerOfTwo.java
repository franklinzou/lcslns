/*
 * Power of Two
 * Tag: Math
 * Tag: Bit Manipulation
 */
import java.util.*;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        // n & (n - 1) removes final '1' in bit representation (0 if no '1')
        // any positive and 0-after-remove-last-1 number is power of 2
        return n > 0 && (n & (n - 1)) == 0;
    }
}