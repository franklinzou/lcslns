/*
 * Excel Sheet Column Title
 * Tag: Math
 */
import java.util.*;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder resBld = new StringBuilder();
        int rem = n;
        // scope-changing problem: we want a string whose results by base-26 equals rem
        // when digit is 0, we need to use 'Z' to indicate 26, so rem is deducted by 26
        // (task amount becomes less)
        while(rem != 0){
            char dig = (char)('A' + (rem % 26 + 25) % 26);
            resBld.insert(0, dig);
            if(dig == 'Z') rem -= 26;
            rem /= 26;
        }
        
        return resBld.toString();
    }
}