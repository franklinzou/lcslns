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
        while(l <= r){
            if(nums[l] == 0){
                //tricky point here: 
                nums[l++] = 1;
                nums[p1++] = 0;
            }
            else if(nums[l] == 1) l++;
            else{
                nums[l] = nums[r];
                nums[r--] = 2;
            }
        }
    }
}