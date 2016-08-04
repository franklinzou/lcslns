/*
 * First Bad Version
 * Tag: Binary Search
 */
import java.util.*;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        // For any i < l, i is not a bad version; for any i > r, i is a bad version. Ends when l > r
        int l = 0, r = n - 1;
        while(l <= r){
            // use new notation to avoid overflow
            int m = l + (r - l + 1) / 2;
            if(isBadVersion(m)) r = m - 1;
            else l = m + 1;
        }
        return l;
    }
}