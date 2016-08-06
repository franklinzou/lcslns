/*
 * Number of Digit One
 * Tag: Math
 */
import java.util.*;

public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        // tricky allCnt here!!
        int res = 0, all = 0, allCnt = 1, rem = n;
        // we use method of extracting effective digits, so res = 0 serves as default answer when n = 0
        // For example of 123456, in iterations, res is the count for range 0 - 6, 0 - 56, 0 - 456..., and all is the count for 0 - 9, 0 - 99, 0 - 999, ...
        while(rem > 0){
            int digVal = rem % 10;
            rem /= 10;
            res += digVal * all;
            // consider extra new 1s brought by numbers with leading 1, two cases are considered
            if(digVal > 1) res += allCnt;
            if(digVal == 1) res += n % allCnt + 1; // note +1 here
            all = all * 10 + allCnt;
            allCnt *= 10;
        }
        return res;
    }
}