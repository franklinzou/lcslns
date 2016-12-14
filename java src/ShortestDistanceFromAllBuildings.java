/*
 * Shortest Distance from All Buildings
 * Tag: Breadth-first Search
 */
import java.util.*;

public class ShortestDistanceFromAllBuildings {
    // Basic idea: use whether a block can connect to all previous buildings to prune
    private int [][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int shortestDistance(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length, accSign = 0, res = Integer.MAX_VALUE;
        int [][] disSum = new int[m][n];
        for(int i = 0; i <= m - 1; i ++)
            for(int j = 0; j <= n - 1; j ++) {
                if(grid[i][j] == 1) {
                    int dist = 1;
                    Queue<Integer> q = new LinkedList<Integer>();
                    q.offer(i * n + j);
                    while(!q.isEmpty()) {
                        int qSize = q.size();
                        for(int k = 1; k <= qSize; k ++) {
                            int s = q.poll(), r = s / n, c = s % n;
                            for(int [] dir : dirs) {
                                int newR = r + dir[0], newC = c + dir[1];
                                // have access to n - 1 buildings && not visited in the current round <=>
                                // grid[i][j] == accSign
                                if(valid(m, n, newR, newC) && grid[newR][newC] == accSign) {
                                    grid[newR][newC] --;
                                    disSum[newR][newC] += dist;
                                    q.offer(newR * n + newC);
                                }
                            }
                        }
                        dist ++;
                    }
                    accSign --;
                }
            }

        for(int i = 0; i <= m - 1; i ++)
            for(int j = 0; j <= n - 1; j ++)
                if(grid[i][j] == accSign)
                    res = Math.min(res, disSum[i][j]);

        return res == Integer.MAX_VALUE ? -1 : res;            
    }
    
    private boolean valid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}
