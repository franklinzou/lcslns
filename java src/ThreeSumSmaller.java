/*
 * 3Sum Smaller
 * Tag: Two Pointers
 * Tag: Array
 */
import java.util.*;
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i <= len - 3; i++){
            //similar to 15. 3Sum
            int newTarget = target - nums[i], l = i + 1, r = len - 1;
            while(l < r){
                if(nums[l] + nums[r] >= newTarget) r--;
                else{
                    //we only consider results formed by nums[l..r] as others have been considered by guarantee
                    res += (r - l);
                    l++;
                }
            }
        }
        return res;
    }
}