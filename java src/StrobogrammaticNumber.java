/*
 * Strobogrammatic Number
 * Tag: Math
 * Tag: Hash Table
 */
import java.util.*;

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int n = num.length(), l = 0, r = n - 1;
        while(l <= r)
            if(!check(num.charAt(l++) - '0', num.charAt(r--) - '0'))
                return false;
        return true;
    }
    
    private boolean check(int lNum, int rNum){
        return (lNum == 0 && rNum == 0) || (lNum == 1 && rNum == 1) || (lNum == 8 && rNum == 8) 
        || (lNum == 6 && rNum == 9) || (lNum == 9 && rNum == 6);
    }
}