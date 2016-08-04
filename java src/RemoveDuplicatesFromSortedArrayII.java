/*
 * Remove Duplicates from Sorted Array II
 * Tag: Array
 * Tag: Two Pointers
 */
import java.util.*;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        // the count of last effective element in the result array
        int l = 0, r = 0, count = 0;
        while(r < len){
            // if this is not a repeat or only appears once before, put it into result
            if(l == 0 || nums[r] != nums[l - 1] || count == 1){
                // update count
                if(l == 0 || nums[l - 1] != nums[r]) count = 1;
                else count++;
                nums[l++] = nums[r];
            }
            r++;
        }
        return l;
    }
}