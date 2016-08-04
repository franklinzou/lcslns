/*
 * Excel Sheet Column Title
 * Tag: Math
 */
import java.util.*;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder resBld = new StringBuilder();
        int rem = n;
        // TODO: full analysis
        while(rem != 0){
            char dig = (char)('A' + (rem % 26 + 25) % 26);
            resBld.insert(0, dig);
            if(dig == 'Z') rem -= 26;
            rem /= 26;
        }
        
        return resBld.toString();
    }
}