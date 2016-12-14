/*
 * N-Queens
 * Tag: Backtracking
 */
import java.util.*;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        boolean[] cols = new boolean[n], down = new boolean[2 * n - 1], up = new boolean[2 * n - 1];
        helper(res, n, 0, cols, down, up, new ArrayList<String>());
        return res;
    }
    /*
     * Validation (given preRes, n, r, cols, down, up):
     * fp = preRes[0,r][:]
     * No Conflict
     */
    private void helper(List<List<String>> res, int n, int r, boolean[] cols, 
        boolean[] down, boolean[] up, List<String> preRes) {
    	// Direct Answer
        if(r == n){
            res.add(new ArrayList<String>(preRes));
            return;
        }
        // Branching with pruning inside: it is trivial to see initial preRes has no conflict
        for(int i = 0; i <= n - 1; i++){
            if(!cols[i] && !down[r + i] && !up[r + n - 1 - i]){
                char [] newRow = new char[n];
                Arrays.fill(newRow, '.');
                newRow[i] = 'Q';
                preRes.add(new String(newRow));
                cols[i] = down[r + i] = up[r + n - 1 - i] = true;
                helper(res, n, r + 1, cols, down, up, preRes);
                preRes.remove(preRes.size() - 1);
                cols[i] = down[r + i] = up[r + n - 1 - i] = false;
            }
        }
    }
}