/*
 * Tag: Two Pointers
 * Tag: Array
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int l = 0, r = 0;
        // we guarantee before each iteration, nums[S..l-1] are ordered non-zeros, nums[l] is OUT OR zero, for any i in [l, r-1], nums[i] = 0
        // in other words, nums[S..r-1] is already a correct part and [l serves as the split line
        while(l < len && nums[l] != 0){
            l++;
            r++;
        }
        
        while(r < len){
            if(nums[r] == 0) r++;
            else{
                nums[l] = nums[r];
                nums[r] = 0;
                l++;
                r++;
            }
        }
    }
}