/*
 * Multiply Strings
 * Tag: Math
 * Tag: String
 */
import java.util.*;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int [] resArr = new int[len1 + len2]; // the longest possible result length is len1 + len2
        for(int i = 0; i <= len1 - 1; i++)
            for(int j = 0; j <= len2 - 1; j++)
                // in num1, distance towards end (dis1) is len1 - 1 - i, in num2, dis2 = len2 - 1 - j
                // in resArr, dis = dis1 + dis2. So its index is (len1 + len2 - 1) - dis =  i + j + 1
                resArr[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        // get real digit values
        int carrier = 0;
        for(int i = len1 + len2 - 1; i >= 0; i--){
            resArr[i] += carrier;
            carrier = resArr[i] / 10;
            resArr[i] %= 10;
        }
        // General: type: string to number:
        StringBuilder resBld = new StringBuilder();
        boolean appending = false;
        for(int i = 0; i <= resArr.length - 1; i++){
            if(resArr[i] != 0){
                appending = true;
                resBld.append((char)(resArr[i] + '0'));
            }
            // if not appending, but at first digit, we need to append 0 anyway
            else if(appending || i == resArr.length - 1) resBld.append('0');
        }
        return resBld.toString();
    }
}