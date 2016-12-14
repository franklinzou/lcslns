/*
 * Count of Range Sum
 * Tag: Divide and Conquer
 * Tag: Binary Indexed Tree
 */
import java.util.*;

public class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        // Divide and conquer method
        int n = nums.length;
        long [] preSums = new long[n + 1];
        for(int i = 1; i <= n; i ++)
            preSums[i] = preSums[i - 1] + nums[i - 1];
        // Note n here as preSums has size of n + 1
        return mergeSort(preSums, 0, n, lower, upper);
        // TODO: Binary indexed tree method
        
    }
    
    private int mergeSort(long [] preSums, int s, int e, int lower, int upper) {
        // when s = e, the element count is 1 and we return directly
        if(e == s) return 0;
        int m = (s + e + 1) / 2, res = 0;
        res += mergeSort(preSums, s, m - 1, lower, upper);
        res += mergeSort(preSums, m, e, lower, upper);
        long [] tmp = new long[e - s + 1];
        // NOTE: two pointer: bound search!
        // maximal bound such that for any smaller j: 
        // preSums[j] - preSums[i] < lower; 
        // preSums[j] - preSums[i] <= upper
        // preSums[j] < preSums[i]
        int j1 = m, j2 = m, j3 = m, ind = 0;
        for(int i = s; i <= m - 1; i ++) {
            for(; j1 <= e && preSums[j1] - preSums[i] < lower; j1 ++);
            for(; j2 <= e && preSums[j2] -preSums[i] <= upper; j2 ++);
            for(; j3 <= e && preSums[j3] < preSums[i]; j3 ++)
                tmp[ind ++] = preSums[j3];
            tmp[ind ++] = preSums[i];
            res += (j2 - j1);
        }   
        //NOTE: type: later trigger: put the remaining elements to the tmp array
        for(; j3 <= e; j3 ++) tmp[ind ++] = preSums[j3];
        // sort preSums[s..e] with tmp!
        for(int i = s; i <= e; i ++) preSums[i] = tmp[i - s];
        return res;
    }
}
