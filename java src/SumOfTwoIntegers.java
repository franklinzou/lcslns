/*
 * Sum of Two Integers
 * Tag: Bit Manipulation
 */
import java.util.*;

public class SumOfTwoIntegers {
    // the idea is decomposition: 101 + 110 = 011 + 1000 (when 1XXX + 1YYY, leave 0ZZZ at the place and add extra 10000 in the extPart for future addition)    
    // TODO: show the algorithm will end
    public int getSum(int a, int b) {
        if(b == 0) return a;
        int basis = a ^ b;
        int addiAdder = (a & b) << 1;
        return getSum(basis, addiAdder);
    }
}