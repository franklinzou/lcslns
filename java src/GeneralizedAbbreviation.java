/*
 * Generalized Abbreviation
 * Tag: Bit Manipulation
 * Tag: Backtracking
 */
import java.util.*;

public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        int n = word.length(), cnt = 1 << n;
        List<String> res = new ArrayList<String>();
        for(int i = 0; i <= cnt - 1; i++){
            StringBuilder strBld = new StringBuilder();
            int preSkipCnt = 0, rem = i;
            for(int j = 0; j <= n - 1; j++){
                if((rem & 1) == 0) preSkipCnt++;
                else{
                    if(preSkipCnt != 0) strBld.append(preSkipCnt);
                    preSkipCnt = 0;
                    strBld.append(word.charAt(j));
                }
                rem >>= 1;
            }
            // NOTE: general: later trigger problem!!
            if(preSkipCnt != 0) strBld.append(preSkipCnt);
            res.add(strBld.toString());
        }
        return res;
        // TODO: backtracking method
    }
}