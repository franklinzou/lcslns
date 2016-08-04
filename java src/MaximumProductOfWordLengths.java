/*
 * Maximum Product of Word Lengths
 * Tag: Bit Manipulation
 */
import java.util.*;

public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int n = words.length, res = 0;
        int [] reps = new int[n]; // with default values 0
        for(int i = 0; i <= n - 1; i++){
            int wordLen = words[i].length();
            for(int j = 0; j <= wordLen - 1; j++) 
                reps[i] |= 1 << (words[i].charAt(j) - 'a');
        }
        for(int i = 0; i <= n - 2; i++)
            for(int j = i + 1; j <= n - 1; j++){
                // reps[i] & reps[j] == 0 <=> words[i] and words[j] do not share common char
                if((reps[i] & reps[j]) == 0)
                    res = Math.max(res, words[i].length() * words[j].length());
            }
            
        return res;
    }
}