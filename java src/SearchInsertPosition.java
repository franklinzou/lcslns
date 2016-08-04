/*
 * Search Insert Position
 * Tag: Binary Search
 * Tag: Array
 */
import java.util.*;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // actually return the lower bound in nums given target:
        // the smallest index with number equal to or larger than target
        int n = nums.length, l = 0, r = n - 1;
        while(l <= r){
            int m = l + (r - l + 1) / 2;
            if(nums[m] < target) l = m + 1;
            else r = m - 1;
        }
        return l;
    }
}