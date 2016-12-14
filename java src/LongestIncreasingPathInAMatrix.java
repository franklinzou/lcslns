/*
 * Longest Increasing Path in a Matrix
 * Tag: Depth-first Search
 * Tag: Topological Sort
 * Tag: Memorization
 */
import java.util.*;

public class LongestIncreasingPathInAMatrix {
    // DFS + memorization
    private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0 ,1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, res = 0;
        int [][] best = new int[m][n];
        
        for(int i = 0; i <= m - 1; i++)
            for(int j = 0; j <= n - 1; j++)
                //a trivial pruning here, if dp has been calculated, then it has been 
                // used somewhere, and cannot be the maximum
                if(best[i][j] == 0) res = Math.max(res, bestFromStart(i, j, matrix, best));
                
        return res;        
    }
    
    // get length of LIP starting from (r, c)
    // we guarantee input (r, c) is valid. Direct bottom-up with branching control
    private int bestFromStart(int r, int c, int[][] matrix, int[][] best) {
        if(best[r][c] != 0) return best[r][c];
        // NOTE: general: set maxChild for default answer (sum model)
        int maxChild = 0, m = matrix.length, n = matrix[0].length;
        for(int i = 0; i <= 3; i++){
            int newR = r + dirs[i][0], newC = c + dirs[i][1];
            // NOTE: type: as validity of child relies on current (r, c), we do branching control here for simplicity
            if(valid(newR, newC, m, n) && matrix[newR][newC] > matrix[r][c]) 
                maxChild = Math.max(maxChild, bestFromStart(newR, newC, matrix, best));
        }
        best[r][c] = maxChild + 1;
        return best[r][c];
    }
    
    private boolean valid(int r, int c, int m, int n){
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}