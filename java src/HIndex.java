/*
 * H-Index
 * Tag: Hash Table
 * Tag: Sort
 */
import java.util.*;

public class HIndex {
    public int hIndex(int[] citations) {
        /*
         * find the maximal h such that there exists at least h papers with citations no smaller than h
         * <=> citations[len - h] >= h, h >= 1 assuming citations are sorted
         */
        int n = citations.length;
        int [] cnts = new int[n + 1];
        // number of citations > i before i-iteration
        int totalLarger = 0;
        for(int num : citations) {
            if(num > n) totalLarger ++;
            else cnts[num] ++;
        }
        // must exist between 0 and n
        for(int i = n; i >= 0; i --) {
            totalLarger += cnts[i]; // total number of citations no smaller than i
            if(totalLarger >= i) return i;
        }
        return -1; // should not reach here
    }
}
