/*
 * Majority Element
 * Tag: Array
 * Tag: Divide and Conquer
 * Tag: Bit Manipulation
 */
import java.util.*;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        // divide and conquer method: 
        // basic idea is if a number is not majority number in either left
        // or right region, it is not the majority number        
        return helper(nums, 0, nums.length - 1);
        // TODO: bit manipulation method
        
    }
    // check whether the target is the majority element in a certain range
    private boolean check(int [] nums, int s, int e, int target) {
        int cnt = 0;
        for(int i = s; i <= e; i ++)
            if(nums[i] == target) cnt ++;
        return cnt > (e - s + 1) / 2;
    }
    
    private int helper(int [] nums, int s, int e) {
        if(s == e) return nums[s];
        else {
            int m  = (s + e + 1) / 2;
            int lRes = helper(nums, s, m - 1), rRes = helper(nums, m, e);
            if(lRes != Integer.MAX_VALUE && check(nums, s, e, lRes)) return lRes;
            if(rRes != Integer.MAX_VALUE && check(nums, s, e, rRes)) return rRes;
            // use INT_MAX to indicate no majority method
            return Integer.MAX_VALUE;
        }
    }
}
