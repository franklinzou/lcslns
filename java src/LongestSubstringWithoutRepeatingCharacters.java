/*
 * Longest Substring Without Repeating Characters
 * Tag: String
 * Tag: Two Pointers
 * Tag: Hash Table
 */
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), res = 0;
        char [] arr= s.toCharArray();
        int [] occ = new int[256];
        for(int i = 0; i <= occ.length - 1; i++) occ[i] = -1;
        // we guarantee s[l..r-1] the longest desirable string for any string ending at s[r-1]
        int l = 0, r = 0;
        while(r < len){
            // we find longest desirable string ending AT r
            if(occ[arr[r]] >= l) l = occ[arr[r]] + 1;
            occ[arr[r]] = r; //update occurrence
            res = Math.max(res, r - l + 1);
            // update r to complete the guarantee
            r++;
        }
        return res;
    }
}