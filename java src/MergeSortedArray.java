/*
 * Tag: Two Pointers
 * Tag: Array
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // we guarantee nums1[ptr1] or nums2[ptr2] are minimum amoung all remaining numbers before iteration
        int [] tmp = new int[m + n];
        int ind = 0, ptr1 = 0, ptr2 = 0;
        // notice the ending condition, we continue when something remains
        while(ptr1 < m || ptr2 < n){
            if(ptr1 == m) tmp[ind++] = nums2[ptr2++];
            else if(ptr2 == n) tmp[ind++] = nums1[ptr1++];
            else{
                if(nums1[ptr1] > nums2[ptr2]) tmp[ind++] = nums2[ptr2++];
                else tmp[ind++] = nums1[ptr1++];
            }
        }
        for(int i = 0; i <= m + n - 1; i++) nums1[i] = tmp[i];
        
        /*
        // we guarantee nums1[ptr1] is the minimum among all remaining numbers WHEN we TAKE it
        int [] tmp = new int[m + n];
        int ind = 0, ptr1 = 0, ptr2 = 0;
        // notice different condition here
        while(ptr1 < m){
            while(ptr2 < n && nums2[ptr2] < nums1[ptr1]) tmp[ind++] = nums2[ptr2++];
            tmp[ind++] = nums1[ptr1++];
        }
        while(ptr2 < n) tmp[ind++] = nums2[ptr2++];
        for(int i = 0; i <= m + n - 1; i++) nums1[i] = tmp[i];
        */
    }
}