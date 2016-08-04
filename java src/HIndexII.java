/*
 * H-Index II
 * Tag: Binary Search
 */
import java.util.*;

public class HIndexII {
    public int hIndex(int[] citations) {
        // when we find citations[i] >= n - i, then h-index is at least n - i; therefore we need to find smallest i
        // such that citations[i] + i - n >= 0: key lies in citations[i] + i - n is non-decreasing function w.r.t. i
        int n = citations.length;
        int l = 0, r = n - 1;
        while(l <= r){
            int m = l + (r - l + 1) / 2;
            if(citations[m] + m - n < 0) l = m + 1;
            else r = m - 1;
        }   
        return n - l;
    }
}