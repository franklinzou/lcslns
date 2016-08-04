/*
 * Find Minimum in Rotated Sorted Array II
 * Tag: Binary Search
 * Tag: Array
 */
import java.util.*;

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int n = nums.length, l = 0, r = n - 1;
        while(l < r - 1){
            int m = l + (r - l + 1) / 2;
            if(nums[m] < nums[r]) r = m;
            else if(nums[m] > nums[r]) l = m;
            // when m < r (m != r), shifting r can still guarantee the assumption 
            else r -= 1;
        }
        return Math.min(nums[l], nums[r]);
    }
}