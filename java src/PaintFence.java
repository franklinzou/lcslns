/*
 * Paint Fence
 * Tag: Dynamic Programming
 */
import java.util.*;

public class PaintFence {
    public int numWays(int n, int k) {
        // NOTE: General: not use default answer for n == 0 case, hard to merge
        if(n == 0 || k == 0) return 0;
        int conSame = 0, conDiff = k;
        for(int i = 2; i <= n; i ++){
            int tmp = conSame;
            conSame = conDiff;
            conDiff = (tmp + conDiff) * (k - 1);
        }
        return conSame + conDiff;
    }
}