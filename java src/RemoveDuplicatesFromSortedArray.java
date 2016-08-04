/*
 * Remove Duplicates from Sorted Array
 * Tag: Two Pointers
 * Tag: Array
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int l = 0, r = 0;
        // we guarantee distinct numbers in nums[S..r - 1] have been put into nums[S..l - 1] before next iteration
        while(r < len){
            if(l == 0 || nums[r] > nums[l - 1]) nums[l++] = nums[r];
            r++;
        }
        return l;
    }
}