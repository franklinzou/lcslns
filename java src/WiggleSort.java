/*
 * Wiggle Sort
 * Tag: Array
 * Tag: Sort
 */
import java.util.*;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        boolean sle = true;
        // if a >= b > c, swap b and c, will make a >= c < b
        // if a <= b < c, swap b and c will make a <= c > b
        for(int i = 0; i <= nums.length - 2; i ++) {
            if((sle && nums[i] > nums[i + 1]) || (!sle && nums[i] < nums[i + 1]))
                swap(nums, i, i + 1);
            sle = !sle;    
        }
    }
    
    private void swap(int [] nums, int s, int e) {
        int tmp = nums[s];
        nums[s] = nums[e];
        nums[e] = tmp;
    }
};
