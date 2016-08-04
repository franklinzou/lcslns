/*
 * Guess Number Higher or Lower
 * Tag: Binary Search
 */
import java.util.*;

public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        // for any i < l, i is smaller; for any i > r, i is larger
        int l = 1, r = n;
        while(l <= r){
            int m = l + (r - l + 1) / 2;
            int guessRes = guess(m);
            if(guessRes == 0) return m;
            else if(guessRes > 0) l = m + 1;
            else r = m - 1;
        }
        
        return -1;
    }
}