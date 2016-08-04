/*
 * Missing Number
 * Tag: Bit Manipulation
 * Tag: Array
 * Tag: Math
 */
import java.util.*;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        // based on xor trick, only missing number is xor-ed once while others are xor-ed twice
        int n = nums.length, res = 0;
        for(int i = 0; i <= n; i++) res ^= i;
        for(int i = 0; i <= n - 1; i++) res ^= nums[i];
        return res;
    }
}