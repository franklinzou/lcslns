/*
 * Single Number II
 * Tag: Bit Manipulation
 */
import java.util.*;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int [] bitSums = new int[32];
        int n = nums.length;
        for(int i = 0; i <= n - 1; i++){
            int rem = nums[i];
            for(int j = 31; j >= 0; j--){
                bitSums[j] += rem & 1;
                rem >>= 1;
            }
        }
        
        int res = 0;
        for(int i = 0; i <= 31; i++){
            res <<= 1;
            res |= bitSums[i] % 3;
        }
        return res;
    }
}