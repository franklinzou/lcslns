/*
 * Tag: Two Pointers
 * Tag: Array
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int l = 0, r = 0;
        //the same idea from problem 283. Move Zeros
        while(l < len && nums[l] != val) l++;
        r = l;
        while(r < len){
            if(nums[r] == val) r++;
            else{
                nums[l] = nums[r];
                nums[r] = val;
                l++;
                r++;
            }
        }
        return l;
    }
}