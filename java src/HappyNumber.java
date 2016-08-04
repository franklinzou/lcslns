/*
 * Happy Number
 * Tag: Math
 * Tag: Hash Table
 */
import java.util.*;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<Integer>();
        int num = n;
        while(num != 1){
            // check whether n appears previously
            if(s.contains(num)) return false;
            s.add(num);
            num = getDigitSqrSum(num);
            // can also use iterative extraction to calculate square sum
        }
        
        return true;
    }
    // no need to avoid overflow because digit square sum is not big enough
    private int getDigitSqrSum(int n){
        if(n == 0) return 0;
        int curDig = n % 10;
        return curDig * curDig + getDigitSqrSum(n / 10);
    }
}