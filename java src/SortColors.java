/*
 * Sort Colors
 * Tag: Array
 * Tag: Two Pointers
 * Tag: Sort
 */
import java.util.*;

public class SortColors {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int p1 = 0, l = 0, r = len - 1;
        // Basic Guarantee: number of elements of each type remains unchanged
        // guarantee p1 <= l <= r and for any i in [S..p1-1], nums[i] = 0; for
        // any i in [p1..l-1], nums[i] = 1; any i in [r+1..E], nums[i] = 2.
        while(l <= r){
            if(nums[l] == 0){
                // special judgement for the case where l = p1
                if(l == p1) {l ++; p1 ++;}
                else {nums[p1 ++] = 0; nums[l ++] = 1}
            }
            else if(nums[l] == 1) l++;
            else{
                // actually need to consider the case when l == r, but operation 
                // is not affected
                nums[l] = nums[r];
                nums[r--] = 2;
            }
        }
    }
}