/*
 * Minimum Window Substring
 * Tag: Hash Table
 * Tag: Two Pointers
 * Tag: String
 */
import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
    	// guarantee (l,r) is the best desirable range ending at r or l = 0
        int missing = t.length(), len = s.length(), l = 0, r = 0;
        // (l, r) is desirable <=> missing =0 (sum of non-zero elements in diff array)
        int [] diff = new int[256];
        // NOTE: general: default answer
        int resInd = 0, resLen = Integer.MAX_VALUE;
        for(char c : t.toCharArray()) diff[c] ++;
        while(r <= len - 1) {
        	// update diff array and missing
            if(diff[s.charAt(r)] > 0) missing --;
            diff[s.charAt(r)] --;
            if(missing == 0) {
            	// check whether moving l is safe (not generate new non-zero element in diff)
                while(diff[s.charAt(l)] +1 <= 0) {
                    diff[s.charAt(l)] ++;
                    l ++;
                }
                // update res if possible with best desirable range ending at r
                if(r - l + 1 < resLen) {
                    resLen = r - l + 1;
                    resInd = l;
                }
            }
            r ++;
        }
        // default answer check
        if(resLen == Integer.MAX_VALUE) return "";
        
        return s.substring(resInd, resInd + resLen);
    }
}
