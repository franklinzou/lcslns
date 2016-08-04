/*
 * Bitwise AND of Numbers Range
 * Tag: Bit Manipulation
 */
import java.util.*;

public class BitwiseANDOfNumbersRange {
    int rangeBitwiseAnd(int m, int n) {
        while((n & m) != n) n = n & (n - 1);
        return n;
    }
}