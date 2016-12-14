/*
 * Longest Substring with At Most Two Distinct Characters
 * Tag: Hash Table
 * Tag: Two Pointers
 * Tag: String
 */
import java.util.*;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int [] cnts = new int[256];
        // NOTE: General: default answer
        // disCnt is the count of non-zero elements in the cnts array
        int l = 0, r = 0, len = s.length(), disCnt = 0, res = 0;
        while(r <= len - 1) {
            if(cnts[s.charAt(r)] == 0) disCnt ++;
            cnts[s.charAt(r)] ++;
            // while the range is not valid
            while(disCnt == 3) {
            	// move l and update cnts, disCnt if possible
                cnts[s.charAt(l)] --;
                if(cnts[s.charAt(l)] == 0) disCnt --;
                l ++;
            }
            // update result
            res = Math.max(r - l + 1, res);
            r ++;
        }
        
        return res;
    }
}
