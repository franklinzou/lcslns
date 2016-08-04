/*
 * 3Sum
 * Tag: Two Pointers
 * Tag: Array
 */
import java.util.*;
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length, preNum = -1;
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i <= len - 3; i++){
            // increasing and differnt first, second or third elements <=> different triplets
            if(i != 0 && nums[i] == preNum) continue;
            preNum = nums[i];
            // we guarantee for any i in [S..l - 1] and [r + 1..E], all of its valid pairs have been considered
            int l = i + 1, r = len - 1, target = -nums[i];
            while(l < r){
                // avoid repeat l or r, also satisfy our guarantee
                if(l != i + 1 && nums[l] == nums[l - 1]) l++;
                else if(r != len - 1 && nums[r] == nums[r + 1]) r--;
                
                else if(nums[l] + nums[r] < target) l++;
                else if(nums[l] + nums[r] > target) r--;
                else res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
            }
        }
        return res;
    }
}