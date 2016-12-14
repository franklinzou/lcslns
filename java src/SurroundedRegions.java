/*
 * Surrounded Regions
 * Tag: Breadth-first Search
 * Tag: Union Find
 */
import java.util.*;

public class SurroundedRegions {
    int [][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        // NOTE: type: can also first put all 'O' at edges and do BFS together
        //first and last row
        for(int i = 0; i <= n - 1; i ++) {
            if(board[0][i] == 'O') bfs(board, 0, i);
            if(board[m -1][i] == 'O') bfs(board, m - 1, i);
        }
        // first and last column
        for(int i = 0; i <= m - 1; i ++) {
            if(board[i][0] == 'O') bfs(board, i, 0);
            if(board[i][n - 1] == 'O') bfs(board, i, n - 1);
        }

        for(int i = 0; i <= m - 1; i ++)
            for(int j = 0; j <= n - 1; j ++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
            
    }
    
    private void bfs(char [][] board, int r, int c) {
        int m = board.length, n = board[0].length;
        Queue<Integer> q = new LinkedList<Integer>();
        board[r][c] = 'T';
        q.offer(r * n + c);
        while(!q.isEmpty()) {
            int s = q.poll(), sR = s / n, sC = s % n;
            for(int [] dir : dirs) {
                int newR = sR + dir[0], newC = sC + dir[1];
                if(valid(m, n, newR, newC) && board[newR][newC] == 'O') {
                    board[newR][newC] = 'T';
                    q.offer(newR * n + newC);
                }
            }
        }
    }
    
    private boolean valid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}
