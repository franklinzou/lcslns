/*
 * Integer to Roman
 * Tag: Math
 * Tag: String
 */
import java.util.*;

public class IntegerToRoman {
    public String intToRoman(int num) {
        String [] syms = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int [] vals = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        
        StringBuilder resBld = new StringBuilder();
        int rem = num;
        for(int i = syms.length - 1; i >= 0; i --){
            int cnt = rem / vals[i];
            rem %= vals[i];
            for(int j = 1; j <= cnt; j++) resBld.append(syms[i]);
        }
        
        return resBld.toString();
    }
}