/*
 * Number of Islands
 * Tag: Depth-first Search
 * Tag: Breadth-first Search
 * Tag: Union Find
 */
import java.util.*;

public class NumberOfIslands {
    private int [][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int numIslands(char[][] grid) {
        /*
        // DFS method
        // special judgement for array
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length, res = 0;
        // DFS-method
        for(int i = 0; i <= m - 1; i++)
            for(int j = 0; j <= n - 1; j++){
                if(grid[i][j] == '1') res++;
                dfs(i, j, grid);
            }
        return res; 
        */

        // BFS method
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length, res = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i <= m - 1; i ++)
            for(int j = 0; j <= n - 1; j ++)
                if(grid[i][j] == '1') {
                    res ++;
                    q.offer(i * n + j);
                    grid[i][j] = '2';
                    while(!q.isEmpty()) {
                        int pos = q.poll(), r = pos / n, c = pos % n;
                        for(int k = 0; k <= 3; k ++) {
                            int newR = r + dirs[k][0], newC = c + dirs[k][1];
                            if(valid(m, n, newR, newC) && grid[newR][newC] == '1') {
                                // change it right now to avoid duplicate insertion
                                grid[newR][newC] = '2';
                                q.offer(newR * n + newC);
                            }
                        }
                    }
                }
                
            return res;
   
        // TODO: union find method
    }
    // set connected land blocks to be visited
    private void dfs(int r, int c, char[][] grid){
        int m = grid.length, n = grid[0].length;
        if(!valid(m, n, r, c) || grid[r][c] != '1') return;
        // action here will prevent revisit and infinite loop, act as visited array
        grid[r][c] = '2';
        for(int i = 0; i <= 3; i ++) dfs(r + dirs[i][0], c + dirs[i][1], grid);
    }
    
    // valid function
    private boolean valid(int m, int n, int r, int c){
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}
