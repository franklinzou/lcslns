/*
 * Range Sum Query - Immutable
 * Tag: Dynamic Programming
 */
import java.util.*;

public class NumArray {
    // preSums[i] indicates sum of range [0..i) = [0..i-1], SUM([0, -1]) = 0 for invalid access
    private int [] preSums;
    
    public NumArray(int[] nums) {
        preSums = new int[nums.length + 1];
        for(int i = 0; i <= nums.length - 1; i ++) preSums[i + 1] = preSums[i] + nums[i];
    }

    public int sumRange(int i, int j) {
        // sum([0..j]) - sum([0..i))
        return preSums[j + 1] - preSums[i];   
    }
}