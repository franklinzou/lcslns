/*
 * Walls and Gates
 * Tag: Breadth-first Search
 */
import java.util.*;

public class WallsAndGates {
    private int [][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0 || rooms[0].length == 0) return;
        int m = rooms.length, n = rooms[0].length;
    
        Queue<Integer> q = new LinkedList<Integer>();
        
        // add gates to queue initially
        for(int i = 0; i <= m - 1; i ++)
            for(int j = 0; j <= n - 1; j ++) 
                if(rooms[i][j] == 0) q.offer(i * n + j);
                
        int dist = 0; // the distance to the gate of new valid acquired in the next iteration
        while(!q.isEmpty()) {
            dist ++;
            int qSize = q.size();
            for(int i = 1; i <= qSize; i ++) {
                int s = q.poll(), r = s / n, c = s % n;
                for(int [] dir : dirs) {
                    int newR = r + dir[0], newC = c + dir[1];
                    // rooms[newR][newC] == Integer.MAX_VALUE to indicate walkable and non-visited
                    if(valid(m, n, newR, newC) && rooms[newR][newC] == Integer.MAX_VALUE) {
                        rooms[newR][newC] = dist;
                        q.offer(newR * n + newC);
                    }
                }
            }
        }
    }
    
    private boolean valid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}
