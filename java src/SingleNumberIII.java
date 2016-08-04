/*
 * Single Number III
 * Tag: Bit Manipulation
 */
import java.util.*;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xorRes = 0, n = nums.length;
        for(int i = 0; i <= n - 1; i++) xorRes ^= nums[i];
        // filter is got by making any bit left to last '1' to '0' in xorRes
        // As two numbers are different, such '1' must exist
        int filter = xorRes & (~(xorRes - 1));
        int [] res = new int[2]; // default 0
        // group numbers by filter, guarantee two distinct numbers are calculated 
        // separately, same values are calculated together
        for(int i = 0; i <= n - 1; i++){
            if((nums[i] & filter) == 0) res[0] ^= nums[i];
            else res[1] ^= nums[i];
        }
        return res;
    }
}