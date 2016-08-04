/*
 * Search in Rotated Sorted Array
 * Tag: Binary Search
 * Tag: Array
 */
import java.util.*;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length, l = 0, r = n - 1;
        // we guarantee any i < l or i > r, nums[i] != target
        while(l <= r){
            int m = l + (r - l + 1) / 2;
            if(nums[m] == target) return m;
            
            if(nums[m] <= nums[r]){
                if(nums[m] > target || nums[r] < target) r = m - 1;
                else l = m + 1;
            }
            else{
                if(nums[m] < target || nums[l] > target) l = m + 1;
                else r = m - 1;
            }
        }
        
        return -1;
    }
}