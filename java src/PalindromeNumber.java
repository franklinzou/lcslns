/*
 * Palindrome Number
 * Tag: Math
 */
import java.util.*;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int divider = 1, len = 1;
        // divider is largest 10^x such that x/10^x < 10; general way to get number string length
        while(x / divider >= 10){
            divider *= 10;
            len ++;
        }
        int l = 0, r = len - 1, rem = x;
        while(l < r){
            if(rem / divider != rem % 10) return false;
            rem = (rem % divider) / 10;
            divider /= 100;
            l ++;
            r --;
        }
        return true;
    }
}