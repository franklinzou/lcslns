/*
 * Wiggle Subsequence
 * Tag: Dynamic Programming
 * Tag: Greedy
 */
import java.util.*;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        /*
        // O(n^2) solution, similar to largest divisible set
        // NOTE: general: pre-lookup and default answer (n == 0)
        int n = nums.length, res = 0;
        int [] dpP = new int[n], dpN = new int[n];
        for(int i = 0; i <= n - 1; i++){
            //dpP[i] and dpN[j] both are 0, suitable for default answer of child count
            for(int j = i - 1; j >= 0; j --){
                if(nums[i] - nums[j] > 0) dpP[i] = Math.max(dpP[i], dpN[j]);
                else if(nums[i] - nums[j] < 0) dpN[i] = Math.max(dpN[i], dpP[j]);
            }
            dpP[i] += 1;
            dpN[i] += 1;
            res = Math.max(res, Math.max(dpP[i], dpN[i]));
        }
        return res;
        */
        // O(n) solution
        // Proof: https://discuss.leetcode.com/topic/52052/c-0ms-o-n-dynamic-programming-solution/6
        int n = nums.length;
        if(n == 0) return 0;
        int resP = 1, resN = 1; // prepared for the defined answer for n == 1!!
        for(int i = 1; i <= n - 1; i++){
            if(nums[i] > nums[i - 1]) resP = resN + 1;
            else if(nums[i] < nums[i - 1]) resN = resP + 1;
        }
        return Math.max(resP, resN);
    }
}