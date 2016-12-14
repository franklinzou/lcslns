/*
 * Median of Two Sorted Arrays
 * Tag: Binary
 * Tag: Array
 * Tag: Divide and Conquer
 */
import java.util.*;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // NOTE: type: k-th number is counted from 1 while index is counted from 0
        if((m + n) % 2 == 1)
            return findKth(nums1, 0, nums2, 0, (m + n + 1) / 2);
        else{
            int lMed = findKth(nums1, 0, nums2, 0, (m + n) / 2);
            int rMed = findKth(nums1, 0, nums2, 0, (m + n) / 2 + 1);
            return (lMed + rMed) / 2.0;
        }
    }
    
    private int findKth(int [] nums1, int s1, int [] nums2, int s2, int k) {
        // Basic idea: a simple conclusion: for previous a elements in A and previous b elements in b,
        // if A(a) < B(b), then all previous a elements in A cannot be (a+b)-th elements in (A+B).
        int rem1 = nums1.length - s1, rem2 = nums2.length -s2;
        if(rem1 == 0) return nums2[s2 + k - 1];
        if(rem2 == 0) return nums1[s1 + k - 1];
        
        if(k == 1) return Math.min(nums1[s1], nums2[s2]);
        int checkCnt1 = -1, checkCnt2 = -1;
        // NOTE: the ideal split would be (k/2, k/2), but if the SMALLER array cannot hold that much, we
        // use LARGER array to hold more!!
        if(rem1 < rem2) {
            checkCnt1 = Math.min(rem1, k / 2);
            checkCnt2 = k - checkCnt1;
        }
        else {
            checkCnt2 = Math.min(rem2, k / 2);
            checkCnt1 = k - checkCnt2;            
        }

        int p1 = nums1[s1 + checkCnt1 - 1], p2 = nums2[s2 + checkCnt2 - 1];
        
        if(p1 == p2) return p1;
        // if small number of array elements are dropped, then rem for that array would be 0 next iteration
        // otherwise, k/2 elements are dropped and k becomes half
        if(p1 < p2) return findKth(nums1, s1 + checkCnt1, nums2, s2, k - checkCnt1);
        else return findKth(nums1, s1, nums2, s2 + checkCnt2, k - checkCnt2);
    }
};
