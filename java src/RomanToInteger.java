/*
 * Roman to Integer
 * Tag: Math
 * Tag: String
 */
import java.util.*;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character,Integer> symMp = new HashMap<Character,Integer>();
        symMp.put('I', 1);
        symMp.put('V', 5);
        symMp.put('X', 10);
        symMp.put('L', 50);
        symMp.put('C', 100);
        symMp.put('D', 500);
        symMp.put('M', 1000);
        // later-trigger problem
        int preVal = 0, res = 0;
        for(int i = 0; i <= s.length() - 1; i++){
            int curVal = symMp.get(s.charAt(i));
            // way of adding current element depends its next element
            if(curVal <= preVal) res += preVal;
            else res -= preVal;
            preVal = curVal;
        }
        res += preVal;
        return res;
    }
}