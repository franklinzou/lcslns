/*
 * Add Digits
 * Tag: Math
 */
import java.util.*;

public class AddDigits {
	// actually digit root
    public int addDigits(int num) {
        // any number will be reduced to number [0,9] and remain
        // reduced to 9 <=> num % 9 == 0 and num != 0
        // reduced to [1,8] <=> num % 9 = [1,8]
        // reduced to 0 <=> num == 0
        int res = num % 9;
        if(res == 0) return num == 0 ? 0 : 9;
        else return res;
    }
}