/*
 * Permutations II
 * Tag: BackTracking
 */
import java.util.*;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length;
        boolean [] selected = new boolean[n];
        Arrays.sort(nums);
        helper(res, nums, selected, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] nums, boolean[] selected, List<Integer> preList){
        int n = nums.length;
        if(preList.size() == nums.length){
            // NOTE: type: create a new list based on preList
            res.add(new ArrayList<Integer>(preList));
            return;
        }
        for(int i = 0; i <= n - 1; i++){
            // if i has not been selected, and value nums[i] has been selected in for loop
            // General: general: duplicate removal
            if(!selected[i] && (i == 0 || nums[i] != nums[i - 1] || selected[i - 1])){
                selected[i] = true;
                preList.add(nums[i]);
                helper(res, nums, selected, preList);
                selected[i] = false;
                preList.remove(preList.size() - 1);
            }
        }
    }
}