/*
 * Longest Substring with At Most K Distinct Characters
 * Tag: Hash Table
 * Tag: Two Pointers
 * Tag: String
 */
import java.util.*;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int l = 0, r = 0, len = s.length(), disCnt = 0, res = 0;
        int [] cnts = new int[256];
        char [] sArr = s.toCharArray();
        while(r <= len - 1) {
            if(cnts[sArr[r]] == 0) disCnt ++;
            cnts[sArr[r]] ++;
            while(disCnt == k + 1) {
                cnts[sArr[l]] --;
                if(cnts[sArr[l]] == 0) disCnt --;
                l ++;
            }
            res = Math.max(res, r - l + 1);
            r ++;
        }
        
        return res;
    }
}
