/*
 * Add Binary
 * Tag: Math
 * Tag: String
 */
import java.util.*;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder resBld = new StringBuilder();
        int carrier = 0, lenA = a.length(), lenB = b.length();
        int indA = lenA - 1, indB = lenB - 1;
        while(indA >= 0 || indB >= 0 || carrier > 0){
            int aAdd = indA >= 0 ? a.charAt(indA --) - '0' : 0;
            int bAdd = indB >= 0 ? b.charAt(indB --) - '0' : 0;
            int sum = aAdd + bAdd + carrier;
            resBld.insert(0, (char)(sum % 2 + '0'));
            carrier = sum / 2;
        }
        return resBld.toString();
    }
}