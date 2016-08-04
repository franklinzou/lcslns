/*
 * Search for a Range
 * Tag: Binary Search
 * Tag: Array
 */
import java.util.*;

public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[2];
        res[0] = lowerBound(nums, target);
        res[1] = upperBound(nums, target);
        return res;
    }
    
    private int lowerBound(int [] nums, int target){
        // smallest index of number larger than or equal to target, and do checking
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l <= r){
            int m = l + (r - l + 1) / 2;
            if(nums[m] < target) l = m + 1;
            else r = m - 1;
        }
        // NOTE: boundary check!! (existence issue here)
        return l < n && nums[l] == target ? l : -1;
    }
    
    private int upperBound(int [] nums, int target){
        // smallest index of number larger than target
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l <= r){
            int m = l + (r - l + 1) / 2;
            if(nums[m] <= target) l = m + 1;
            else r = m - 1;
        }
        return l - 1 >= 0 && nums[l - 1] == target ? l - 1 : -1;
    }
}