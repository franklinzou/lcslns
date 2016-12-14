/*
 * Two Sum
 * Tag: Array
 * Tag: Hash Table
 */
import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        int [] res = new int[2];
        // find i and j such that i < j and nums[i] + nums[j] = target
        for(int i = 0; i <= n - 1; i ++) {
            if(map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
