/*
 * Android Unlock Patterns
 * Tag: Dynamic Programming
 * Tag: Backtracking
 */
import java.util.*;

public class AndroidUnlockPatterns {
    public int numberOfPatterns(int m, int n) {
        boolean [][] visited = new boolean[3][3];
        int res = 0;
        res += helper(m, n, 0, 0, 0, visited) * 4;
        res += helper(m, n, 0, 0, 1, visited) * 4;
        res += helper(m, n, 0, 1, 1, visited);
        return res;
    }
    
    // NOTE: type: Current state with next-step plan
    /*
     * Validation:
     * fp = pre_result[0,len]
     * fp.len() \in [m, n]
     * fp[len, len()-1] EXCLUDE pre_result
     * fp[len] = (r, c)
     * Obey Skip Rule
     */
    private int helper(int m, int n, int len, int r, int c, boolean[][] visited){
        // Direct result
    	int newLen = len + 1, res = 0;
    	if(newLen >= m && newLen <= n) res += 1;
    	// No branching
        if(newLen == n) return res;
        
        visited[r][c] = true;
        for(int i = 0; i <= 2; i ++)
            for(int j = 0; j <= 2; j++)
                if(!visited[i][j] && skipCheck(r, c, i, j, visited))
                    res += helper(m, n, len + 1, i, j, visited);
        visited[r][c] = false;            
        return res;    
    }
    
    private boolean skipCheck(int r1, int c1, int r2, int c2, boolean[][] visited) {
        int sum1 = r1 + r2, sum2 = c1 + c2;
        if(sum1 % 2 == 1 || sum2 % 2 == 1) return true;
        return visited[sum1 / 2][sum2 / 2];
    }
}