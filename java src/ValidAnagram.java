/*
 * Valid Anagram
 * Tag: Hash Table
 * Tag: Sort
 */
import java.util.*;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // Map-based
        // s and t are anagram <=> for any character c, sCnt[c] = tCnt[c]
        int [] cnts = new int[26];
        for(char c : s.toCharArray()) cnts[c - 'a'] ++;
        for(char c : t.toCharArray()) cnts[c - 'a'] --;
        for(int i = 0; i <= 25; i ++)
            if(cnts[i] != 0) return false;
        return true;
        // Sort-based
                
    }
}
