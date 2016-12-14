/*
 * Count of Smaller Numbers After Self
 * Tag: Divide and Conquer
 * Tag: Binary Indexed Tree
 * Tag: Segment Tree
 * Tag: Binary Search Tree
 */
import java.util.*;

public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        // divide and conquer solution:
        // merge-sort based solution: sort (indices[i], indices[j]) based on (nums[indices[i]], nums[indices[j]])
        int n = nums.length;
        List<Integer> res = new ArrayList<Integer>();
        if(n == 0) return res;
        int [] indices = new int[n];
        for(int i = 0; i <= n - 1; i ++) {
            res.add(0);
            indices[i] = i;
        }
        helper(nums, indices, 0, n - 1, res);
        return res;
        // TODO: binary indexed tree solution:
        
    }
    
    private void helper(int [] nums, int [] indices, int s, int e, List<Integer> res) {
        if(s == e) return;
        int m = (s + e + 1) / 2;
        helper(nums, indices, s, m - 1, res);
        helper(nums, indices, m, e, res);
        int [] tmp = new int[e - s + 1];
        int j = m, ind = 0;
        // for each indices[i], find smaller elements in indices[m, e], add result to indices[i]
        for(int i = s; i <= m - 1; i ++){
            for(; j <= e && nums[indices[j]] < nums[indices[i]]; j ++)
                tmp[ind ++] = indices[j];
            res.set(indices[i], res.get(indices[i]) + j - m);
            tmp[ind ++] = indices[i];
            //res[indices[i]] += j - m;
        }
        for(; j <= e; j ++) tmp[ind ++] = indices[j];
        for(int i = s; i <= e; i ++) indices[i] = tmp[i - s];
    }
}
