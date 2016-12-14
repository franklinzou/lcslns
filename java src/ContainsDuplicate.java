/*
 * Contains Duplicate
 * Tag: Hash Table
 * Tag: Array
 */
import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        int n = nums.length;
        for(int i = 0; i <= n - 1; i ++)
            if(!s.add(nums[i])) return true;
        return false;
    }
}
