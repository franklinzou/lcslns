/*
 * Contains Duplicate II
 * Tag: Hash Table
 * Tag: Array
 */
import java.util.*;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> s = new HashSet<Integer>();
        for(int i = 0; i <= n - 1; i ++){
            if(!s.add(nums[i])) return true;
            // remove number k-distance from nums[i], so all numbers in set are within (k-1)-distance to nums[i]
            // and k-distance towards i + 1
            if(i - k >= 0) s.remove(nums[i - k]);
        }
        return false;
    }
}
