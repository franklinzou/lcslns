/*
 * Kth Largest Element in an Array
 * Tag: Heap
 * Tag: Divide and Conquer
 */
import java.util.*;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        // Divide and conquer method
        int s = 0, e = nums.length - 1, ord = k;
        while(true) {
            if(s == e) return nums[s];            
            int piv = nums[s], l = s + 1, r = e;
            while(l <= r) {
                /*
                 * we guarantee any number left to l is <= piv, and any number right to r is > piv
                 * we use (<=, >) division here as we need to know number of elements strictly greater
                 * than piv
                 */
                if(nums[l] <= piv) l ++;
                else if(nums[r] > piv) r --;
                else swap(nums, l ++, r --);
            }
            // we should make sure guarantees are still valid in the entire range, so we swap (s, r) 
            swap(nums, s, r);
            
            int largeCnt = e - r; // count of elements strictly larger than piv
            if(largeCnt == ord - 1) return piv;
            else if(largeCnt > ord - 1) s = r + 1;
            // Note that we do not use nums[r] again and change range to [s, r - 1] to 
            // avoid infinite loop when largeCnt = 0
            else {
                e = r - 1;
                ord = ord - largeCnt - 1;
            }
        }
        // TODO: heap method
    }
    /*
    // recursive version
    private int findKthRange(int [] nums, int s, int e, int k) {
        // System.out.println(s + " " + e + " " + k);
        
        int piv = nums[s], l = s + 1, r = e, tmp;
        while(l <= r) {
            // we guarantee any number left to l is <= piv, and any number right to r
            // is > piv
            if(nums[l] <= piv) l ++;
            else if(nums[r] > piv) r --;
            else swap(nums, l ++, r --);
        }
        swap(nums, s, r);
        
        int largeCnt = e - r;
        if(largeCnt == k - 1) return piv;
        else if(largeCnt > k - 1) return findKthRange(nums, r + 1, e, k);
        else return findKthRange(nums, s, r - 1, k - largeCnt - 1);
    }
    */
    private void swap(int [] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }
}
