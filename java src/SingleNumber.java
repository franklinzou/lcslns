/*
 * Single Number
 * Tag: Bit Manipulation
 * Tag: Hash Table
 */
import java.util.*;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        // simply use xor trick: a ^ b ^ a = b
        int n = nums.length, res = 0; // 0 is origin for xor calculation: 0 ^ a = a
        for(int i = 0; i <= n - 1; i++) res = res ^ nums[i];
        return res;
    }
}