/*
 * Permutations
 * Tag: Backtracking
 */
import java.util.*;

public class Permutations {
	/*
	 * FP(nums, pos) = FP(swap(nums, pos, I), pos + 1), I = [pos, len() - 1], len() - pos >= 1
	 * FP(nums, pos) = nums, nums.len() - pos = 0
	 */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // Use IRP = 0, easy to show the equivalence
        // For any array, fp = nums[0,-1], fp ~= nums[0,len()-1] defines fp ~= nums
        helper(res, nums, 0);
        return res;
    }

    /*
     * Validation (given nums, pos):
     * fp = nums[0..pos-1]
     * fp ~= nums[pos, len()-1]
     */
    private void helper(List<List<Integer>> res, int[] nums, int pos) {
        int n = nums.length;
        if(pos == n){
            List<Integer> newList = new ArrayList<Integer>();
            for(int num : nums) newList.add(num);
            res.add(newList);
            return;
        }
        
        for(int i = pos; i <= n - 1; i ++){
            swap(nums, i, pos);
            helper(res, nums, pos + 1);
            swap(nums, i, pos);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;        
    }
}