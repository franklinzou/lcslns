/*
 * Find Minimum in Rotated Sorted Array
 * Tag: Binary Search
 * Tag: Array
 */
import java.util.*;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length, l = 0, r = n - 1;
        // note we use relaxed open condition for validity 1
        while(r - l > 1){
            int m = l + (r - l + 1) / 2;
            if(nums[m] > nums[r]) l = m;
            else r = m;
        }
        // judgement will work in either ending position (l = r or l + 1 = r)
        return Math.min(nums[l], nums[r]);
    }
}