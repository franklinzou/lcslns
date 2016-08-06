/*
 * Fraction to Recurring Decimal
 * Tag: Math
 * Tag: Hash Table
 */
import java.util.*;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        // General: type: input definition: sign problem for 0 result (string)
        if(numerator == 0) return "0"; // avoid "-0" problem
        // remainer and position to put result when dealing with fraction part
        Map<Long, Integer> occur = new HashMap<Long, Integer>(); // note long type
        long absNor = Math.abs((long)numerator), absDor = Math.abs((long)denominator);
        StringBuilder resBld = new StringBuilder();
        if((numerator ^ denominator) >> 31 != 0) resBld.append("-");
        
        resBld.append(absNor / absDor);
        long rem = absNor % absDor;
        if(rem == 0) return resBld.toString(); // stop when remainer is already 0
        /* dealing with fraction part*/
        resBld.append(".");
        rem *= 10;
        while(rem != 0){
            // infinity detection
            if(occur.get(rem) != null){
                int occurPos = occur.get(rem);
                resBld.insert(occurPos, "(");
                resBld.append(")");
                break;
            }
            occur.put(rem, resBld.length());
            resBld.append(rem / absDor);
            rem = rem % absDor * 10;
        }
        
        return resBld.toString();
    }
}