/*
 * Best Meeting Point
 * Tag: Math
 * Tag: Sort
 */
import java.util.*;

public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        // result for undefined input
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length, cnt = 0;
        int [] rowCnt = new int[m], colCnt = new int[n];
        for(int i = 0; i <= m - 1; i++)
            for(int j = 0; j <= n - 1; j++){
                rowCnt[i] += grid[i][j];
                colCnt[j] += grid[i][j];
            }
        return getMinDis(rowCnt) + getMinDis(colCnt);
    }
    
    private int getMinDis(int [] cntArr){
        int l = 0, r = cntArr.length - 1, d = 0;
        // typical scope-changing idea
        // variation of two-pointer-symmetry problem, guarantee number of agents
        // passed by l and r are the same. Do not detect target elements (actually 
        // merged into general routine).
        while(l < r){
            int common = Math.min(cntArr[l], cntArr[r]);
            cntArr[l] -= common;
            cntArr[r] -= common;
            d += common * (r - l);
            if(cntArr[l] == 0) l ++;
            else r --;
        }
        return d;
    }
}