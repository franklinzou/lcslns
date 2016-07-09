/*
 * Tag: Two Pointers
 * Tag: Array
 */
import java.util.*;
public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        // optRealDis indicate the optimal real distance (with minimal absolute value)
        int len = nums.length, optRealDis = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i <= len - 3; i++){
            int l = i + 1, r = len - 1;
            // we guarantee for any j in [S..l-1] and [r+1..E], the best result for nums[j] has been considered
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum <= target) l++;
                else r--;
                if(Math.abs(sum - target) < Math.abs(optRealDis)) optRealDis = sum - target;
            }
        }
        return optRealDis + target;
    }
}