/*
 * Excel Sheet Column Number
 * Tag: Math
 */
import java.util.*;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int len = s.length(), res = 0, mtper = 1;
        for(int i = len - 1; i >= 0; i --){
            // actually write 'Z' instead of advancing, so 'Z' represents 26 * mtper.
            res += (s.charAt(i) - 'A' + 1) * mtper;
            mtper *= 26;
        }
        return res;
    }
}