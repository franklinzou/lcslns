/*
 * Maximum Gap
 * Tag: Sort
 */
import java.util.*;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // basic idea in determining gap: the use the smallest possible maximum gap, so the 
        // maximum gap must come from different buckets. So we only need to consider extreme
        // element in each bucket.
        double gap = (max - min) * 1.0 / (n - 1);
        // special judgement here to avoid problem of dividing by 0
        if(gap == 0) return 0;
        
        boolean [] notEmpty = new boolean[n];
        int [] maxs = new int[n];
        int [] mins = new int[n];
        // group 0 ~ n - 1: [min + gap * i, min + gap * (i + 1)), group n: [max, max]
        for(int num : nums) {
            int group = (int)((num - min) / gap);
            if(!notEmpty[group]) {
                maxs[group] = mins[group] = num;
                notEmpty[group] = true;
            }
            else {
                maxs[group] = Math.max(maxs[group], num);
                mins[group] = Math.min(mins[group], num);
            }
        }
        
        // we use maxs[0] to initialize preMax as it is certain that group 0 is not empty
        int preMax = maxs[0], res = 0;
        // find gap of (max, min) in consecutively NON-EMPTY  bucket
        for(int i = 1; i <= n - 1; i ++) {
            if(notEmpty[i]) {
                System.out.println(preMax + " " + mins[i]);
                res = Math.max(mins[i] - preMax, res);
                preMax = maxs[i];
            }
        }
        return res;
    }
};
